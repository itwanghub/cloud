package com.wang.consul.Controller;

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
public class PaymentController80 {

    @Value("${server.port}")
    public String serverPort;

    @GetMapping("/consul/getPort")
    public String info(){
        return "consul 端口："+serverPort+"--"+ UUID.randomUUID().toString();
    }
}
