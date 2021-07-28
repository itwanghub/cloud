package com.wang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@RestController
public class PaymentController {

    //这里就不操作数据库了，直接返回

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/zookeeper/getPort")
    public String getServerPort(){
        return "zookeeper 端口："+serverPort+"--"+ UUID.randomUUID().toString();
    }
}
