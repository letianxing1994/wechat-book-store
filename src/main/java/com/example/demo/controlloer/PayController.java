package com.example.demo.controlloer;

import com.example.demo.Enum.ResultEnum;
import com.example.demo.dto.OrderDTO;
import com.example.demo.exception.SellException;
import com.example.demo.service.OrderService;
import com.example.demo.service.impl.PayServiceImpl;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayServiceImpl payService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl){
        //1.check status
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2.pay
        payService.create(orderDTO);
    }
}
