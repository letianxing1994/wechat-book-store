package com.example.demo.service;

import com.example.demo.dataobject.ProductInfo;
import com.example.demo.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    //add stock
    void increaseStock(List<CartDTO> cartDTOList);

    //subtract stock
    void decreaseStock(List<CartDTO> cartDTOList);
}
