package com.example.demo.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /** order id .*/
    private String orderId;

    /** product id .*/
    private String productId;

    /** product name .*/
    private String productName;

    /** single price .*/
    private BigDecimal productPrice;

    /** product quantity .*/
    private Integer productQuantity;

    /** product picture .*/
    private String productIcon;
}
