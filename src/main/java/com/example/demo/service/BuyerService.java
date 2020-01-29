package com.example.demo.service;

import com.example.demo.dto.OrderDTO;

public interface BuyerService {

    //check one order
    OrderDTO findOrderOne(String openid, String orderId);

    //cancel order
    OrderDTO cancelOrder(String openid, String orderId);
}
