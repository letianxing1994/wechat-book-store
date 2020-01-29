package com.example.demo.dto;

import com.example.demo.dataobject.OrderDetail;
import com.example.demo.utils.serializer.Data2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /** order id .*/
    private String orderId;

    /** buyer name .*/
    private String buyerName;

    /** buyer's phone number .*/
    private String buyerPhone;

    /** buyer's address .*/
    private String buyerAddress;

    /** buyer's wechat id .*/
    private String buyerOpenid;

    /** order amount .*/
    private BigDecimal orderAmount;

    /** order status .*/
    private Integer orderStatus;

    /** payment status .*/
    private Integer payStatus;

    /** create time .*/
    @JsonSerialize(using = Data2LongSerializer.class)
    private Date createTime;

    /** update time .*/
    @JsonSerialize(using = Data2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList = new ArrayList<>();
}
