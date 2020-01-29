package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WechatMpConfigTest {

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Test
    public void test(){
        log.info("[appid]={}", wechatAccountConfig.getMpAppId());
    }
}