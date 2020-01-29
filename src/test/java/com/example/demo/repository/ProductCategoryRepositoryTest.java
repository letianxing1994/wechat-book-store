package com.example.demo.repository;

import com.example.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findById(1).orElse(null);
        System.out.println(productCategory);
    }

    @Test
    public void SaveOneTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("girl's favorite");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }


    @Test
    public void UpdateOneTest(){
        ProductCategory productCategory = repository.findById(2).orElse(null);
        if(productCategory!=null){
            productCategory.setCategoryName("boy's favorite");
            repository.save(productCategory);
        }
        return;
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3);
        List<ProductCategory> ans = repository.findByCategoryTypeIn(list);
        Assert.assertEquals(2,ans.size());
    }

}