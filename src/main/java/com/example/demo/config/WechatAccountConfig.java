package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    //store number
    private String mchId;

    //store key
    private  String mchKey;

    //store certificate
    private String keyPath;

    //wechat asynchronous validation
    private String notifyUrl;
}
