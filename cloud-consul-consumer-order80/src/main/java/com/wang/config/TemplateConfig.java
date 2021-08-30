package com.wang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@Configuration
public class TemplateConfig {
    @Bean
    public RestTemplate getRestemplate(){
        return new RestTemplate();
    }
}
