package com.example.demo.repository;

import com.example.demo.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("飒飒");
        orderMaster.setBuyerPhone("4127210905");
        orderMaster.setBuyerAddress("3407 iowa street");
        orderMaster.setBuyerOpenid("Le941118");
        orderMaster.setOrderAmount(new BigDecimal(19));

        OrderMaster result = repository.save(orderMaster);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception{
        //from page 0, each page has two items
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderMaster> page = repository.findByBuyerOpenid("Le941118", request);

        Assert.assertEquals(2, page.getTotalElements());
    }
}