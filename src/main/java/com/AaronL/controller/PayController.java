package com.AaronL.controller;


import lombok.extern.slf4j.Slf4j;
import com.AaronL.dto.OrderDTO;
import com.AaronL.enums.ResultEnum;
import com.AaronL.exception.SellException;
import com.AaronL.service.OrderService;
import com.AaronL.service.PayService;
import com.AaronL.utils.JsonUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Aaron on 2018/5/4.
 */

@Controller
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/pay")
    public ModelAndView index(@RequestParam("openid") String openid,
                              @RequestParam("orderId") String orderId,
                              @RequestParam("returnUrl") String returnUrl,
                              Map<String,Object> map){
        log.info("openid={}",openid);
        //1.查询订单
//        String orderId="1234563";
        OrderDTO orderDTO=orderService.findOne(orderId);
        if(orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付
        orderDTO.setBuyerOpenid(openid);
        PayResponse payResponse=payService.create(orderDTO);

        map.put("payResponse",payResponse);
        map.put("returnUrl","http://www.AaronL.com");

        return new ModelAndView("pay/create",map);
    }

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map){
        //1.查询订单
        OrderDTO orderDTO=orderService.findOne(orderId);
        if(orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付
        PayResponse payResponse=payService.create(orderDTO);

        map.put("payResponse",payResponse);
        map.put("returnUrl",returnUrl);

        return new ModelAndView("pay/create",map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){

        log.info("notifyData:{}",notifyData);
        payService.notify(notifyData);

        //返回给微信处理结果
//        String string="";
        return new ModelAndView("pay/success");
    }

}
