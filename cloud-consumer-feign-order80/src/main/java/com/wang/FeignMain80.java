package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@SpringBootApplication
@EnableFeignClients
public class FeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignMain80.class,args);
    }
}
