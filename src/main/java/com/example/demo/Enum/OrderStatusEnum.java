package com.example.demo.Enum;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0,"new order"),
    COMPLETED(1, "completed"),
    CANCEL(2, "cancelled");

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
