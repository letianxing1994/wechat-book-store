package com.example.demo.service;

import com.example.demo.dataobject.OrderMaster;
import com.example.demo.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

@Service
public interface OrderService {

    /** create order .*/
    OrderDTO create(OrderDTO orderDTO);

    /** check one order .*/
    OrderDTO findOne(String orderId);

    /** check order list .*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** cancel order .*/
    OrderDTO cancel(OrderDTO orderDTO);

    /** complete order .*/
    OrderDTO complete(OrderDTO orderDTO);

    /** pay order .*/
    OrderDTO paid(OrderDTO orderDTO);
}
