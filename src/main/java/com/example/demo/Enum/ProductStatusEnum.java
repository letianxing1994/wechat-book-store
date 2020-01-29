package com.example.demo.Enum;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    UP(0),
    OFF(1);

    private Integer code;

    ProductStatusEnum(Integer code){
        this.code = code;
    }
}
