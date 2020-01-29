package com.example.demo.service.impl;

import com.example.demo.Enum.OrderStatusEnum;
import com.example.demo.Enum.PayStatusEnum;
import com.example.demo.dataobject.OrderDetail;
import com.example.demo.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "Le941118";

    @Test
    public void create() throws Exception{
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("sasa");
        orderDTO.setBuyerAddress("3407 iowa street");
        orderDTO.setBuyerPhone("4127210905");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //cart
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("222222");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne("123456");
        log.info("[查询单个订单] result={}", result);
        Assert.assertEquals("123456", result.getOrderId());
    }

    @Test
    public void findList() {
        Page<OrderDTO> result = orderService.findList(BUYER_OPENID, PageRequest.of(0,2));
        Assert.assertEquals(6, result.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("123456");
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void complete() {
        OrderDTO orderDTO = orderService.findOne("123457");
        OrderDTO result = orderService.complete(orderDTO);
        Assert.assertEquals(OrderStatusEnum.COMPLETED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("123457");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}