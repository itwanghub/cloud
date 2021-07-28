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
     * 模拟客户端去调用8004服务提供者
     */
    //public static final String ZOOKEEPER_URL = "http://CLOUD-PAYMENT-SERVER";  //Zookeeper集群的话，开启
    public static final String ZOOKEEPER_URL = "http://localhost:8004";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/zookeeper/getPort")
    public String getInfoFromZookeeper(){
        return restTemplate.getForObject(ZOOKEEPER_URL+"/zookeeper/getPort",String.class);
    }
}
