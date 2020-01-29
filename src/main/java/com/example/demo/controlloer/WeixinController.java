package com.example.demo.controlloer;

import com.example.demo.HttpsClientRequestFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    //get openid of customer through code, get access token from code by url, get open id from access_token
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("enter auth method... code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxef3cd066f60129ae&secret=c7d90bd9c0a8be821f3085e38c878b56&code="+
                code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
        String response =  restTemplate.getForObject(url, String.class);
        log.info("response = {}", response);
    }
}
