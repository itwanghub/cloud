package com.wang;

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
public class ConsulOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrder80.class,args);
    }
}
