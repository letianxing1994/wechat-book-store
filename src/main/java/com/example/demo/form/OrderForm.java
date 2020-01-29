package com.example.demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "phone number is required")
    private String phone;

    @NotEmpty(message = "address is required")
    private String address;

    @NotEmpty(message = "wechat is required")
    private String openid;

    @NotEmpty(message = "cart cannot be empty")
    private String items;
}
