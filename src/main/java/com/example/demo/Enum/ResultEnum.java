package com.example.demo.Enum;

import lombok.Getter;

@Getter
public enum ResultEnum {


    PRODUCT_NOT_EXIST(1,"product does not exist"),
    PRODUCT_STOCK_ERROR(2, "product stock is incorrect"),
    ORDER_NOT_EXIST(3,"order is not valid"),
    ORDER_DETAIL_NOT_EXIST(4,"order's detail is not available"),
    ORDER_STATUS_ERROR(5, "order status is not valid"),
    ORDER_UPDATE_FAIL(6,"order cannot be updated"),
    ORDER_DETAIL_EMPTY(7,"order detail is empty"),
    ORDER_PAYMENT_ERROR(8,"order payment status is not valid"),
    PARAM_ERROR(9,"parameter is incorrect"),
    CART_EMPTY(10,"cart cannot be empty"),
    ORDER_OWNER_ERROR(11, "order doesn't belong to this wechat"),
    WECHAT_MP_ERROR(12, "wechat public account error");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
