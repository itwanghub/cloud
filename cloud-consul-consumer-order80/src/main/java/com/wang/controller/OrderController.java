package com.wang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@RestController
public class OrderController {
    /**
     * 模拟客户端去调用8006服务提供者
     */
    public static final String CONSUL_URL = "http://localhost:8006";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/consul/getPort")
    public String getInfoFromZookeeper(){
        return restTemplate.getForObject(CONSUL_URL+"/consul/getPort",String.class);
    }
}
