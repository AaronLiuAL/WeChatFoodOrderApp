package com.AaronL.service;

import com.AaronL.dto.OrderDTO;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

/**
 * Created by Aaron on 2018/5/8.
 */
public interface OrderService {

    /**create order*/
    OrderDTO create(OrderDTO orderDTO);

    /**lookup single order */
    OrderDTO findOne(String orderId);

    /**lookup order list*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**canncel order*/
    OrderDTO cancel(OrderDTO orderDTO);

    /**finish order*/
    OrderDTO finish(OrderDTO orderDTO);

    /**pay order*/
    OrderDTO paid(OrderDTO orderDTO);

    /**lookup order list with pagenation*/
    Page<OrderDTO> findList(Pageable pageable);
}
