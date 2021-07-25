package com.wang.controller;

import com.wang.entity.CommonResult;
import com.wang.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    /**
     * 调用服务提供者集群，不用单独写死地址，这个名字再每个单独服务的yml中进行配置，
     * 配置好后有个问题，服务端集群有很多机器，具体调用那一台机器提供服务，就要用到负载均衡
     * 因为用的是RestTemplate 调用，所以可以在配置类上增加@LoadBalanced注解，表示启用负载均衡。
     * 否则消费端直接请求会报错，因为不知道服务端集群到底要用那台机器提供服务。
     */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVER";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("参数："+payment.getSerial());
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
