package com.wang.hystrix.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class HystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain80.class,args);
    }
}
