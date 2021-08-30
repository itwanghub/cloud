package com.wang.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPayment80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPayment80.class,args);
    }
}
