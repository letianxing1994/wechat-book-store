package com.example.demo.service.impl;

import com.example.demo.Enum.ResultEnum;
import com.example.demo.dto.OrderDTO;
import com.example.demo.exception.SellException;
import com.example.demo.service.BuyerService;
import com.example.demo.service.OrderService;
import com.example.demo.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if(orderDTO == null){
            log.error("[cancel order]order cannot be found, orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO==null){
            return null;
        }
        //judge whether this order belong to client
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("[check order]order's openid is not consistent,openid={},orderId={}",
                    openid, orderId);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
