package com.example.demo.Enum;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

    WAIT(0, "waiting for pay"),
    SUCCESS(1, "pay successfully");

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
