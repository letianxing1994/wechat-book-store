package com.example.demo.repository;

import com.example.demo.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456789");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("https://gitbook.cn/gitchat/geekbook/5c340f404fcd483b0271742a/topic/5c3416c4e4c35f5a674032ed#52");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("Java并发编程的艺术");
        orderDetail.setProductPrice(new BigDecimal(19));
        orderDetail.setProductQuantity(1);

        OrderDetail orderDetail1 = repository.save(orderDetail);
        Assert.assertNotEquals(null, orderDetail);
    }

    @Test
    public void findByOrderIdTest(){
        List<OrderDetail> res = repository.findByOrderId("123456");
        Assert.assertEquals(1, res.size());
    }
}