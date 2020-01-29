package com.example.demo.service.impl;

import com.example.demo.dataobject.ProductInfo;
import org.hibernate.validator.constraints.EAN;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception{
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0,2);
        Page<ProductInfo> page = productService.findAll(request);
        System.out.println(page.getTotalElements());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> res = productService.findUpAll();
        Assert.assertNotEquals(0, res.size());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("222222");
        productInfo.setProductName("Java网络编程精选");
        productInfo.setProductPrice(new BigDecimal(19));
        productInfo.setProductStock(1000);
        productInfo.setProductDescription("Java分布式书籍推荐");
        productInfo.setProductIcon("https://gitbook.cn/gitchat/geekbook/");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);
        ProductInfo res = productService.save(productInfo);
    }
}