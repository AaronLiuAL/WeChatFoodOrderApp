package com.AaronL.service;

import com.AaronL.dto.OrderDTO;

/**
 * Created by Aaron on 2018/5/8.
 */
public interface BuyerService {

    //lookup single order
    OrderDTO findOrderOne(String openid,String orderId);

    //canncel order
    OrderDTO cancelOrder(String openid,String orderId);

}
