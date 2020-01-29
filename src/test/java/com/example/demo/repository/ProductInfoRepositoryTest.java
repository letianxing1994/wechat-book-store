package com.example.demo.repository;

import com.example.demo.dataobject.ProductInfo;
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
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("Java并发编程的艺术");
        productInfo.setProductPrice(new BigDecimal(19));
        productInfo.setProductStock(1000);
        productInfo.setProductDescription("Java并发书籍推荐");
        productInfo.setProductIcon("https://gitbook.cn/gitchat/geekbook/5c340f404fcd483b0271742a/topic/5c3416c4e4c35f5a674032ed#52");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo res = repository.save(productInfo);
        Assert.assertNotEquals(null, res);
    }

    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> res = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, res.size());
    }



}