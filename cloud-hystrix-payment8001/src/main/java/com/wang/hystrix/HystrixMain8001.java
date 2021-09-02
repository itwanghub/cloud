package com.wang.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //服务降级
public class HystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain8001.class,args);
    }
}
