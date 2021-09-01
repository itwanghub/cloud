package com.wang.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description 调用
 */
@Configuration
public class TemplateConfig {

    //@LoadBalanced
    //自定义轮询算法的时候先把这个注掉
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
