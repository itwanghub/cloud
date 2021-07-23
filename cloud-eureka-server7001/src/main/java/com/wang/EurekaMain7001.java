package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@SpringBootApplication
@EnableEurekaServer   //自己就是Eureka的服务端
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
