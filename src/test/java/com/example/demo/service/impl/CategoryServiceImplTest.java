package com.example.demo.service.impl;

import com.example.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    void findAll() throws Exception {
        List<ProductCategory> ans = categoryService.findAll();
        Assert.assertEquals(new Integer(2), new Integer(ans.size()));
    }

    @Test
    void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> ans = categoryService.findByCategoryTypeIn(Arrays.asList(2,3));
        Assert.assertEquals(new Integer(2), new Integer(ans.size()));
    }

    @Test
    void save() throws Exception {
        ProductCategory pc = new ProductCategory();
        pc.setCategoryName("Operating System");
        pc.setCategoryType(4);
        ProductCategory result = categoryService.save(pc);
        Assert.assertNotEquals(null, result);
    }
}