package com.wang.hystrix.feign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wang.hystrix.feign.service.HyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@RestController
public class HyController {
    @Resource
    private HyService hyService;

    @GetMapping("consumer/payment/ok/{id}")
    public String get_ok(@PathVariable("id") String id){
        return hyService.get_ok(id);
    }

    @GetMapping("consumer/payment/no/{id}")
    @HystrixCommand(fallbackMethod = "error_handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String get_on(@PathVariable("id") String id) {
        return hyService.get_on(id);
    }

    public String error_handler(String id){
        return "对方似乎超时了！-->"+id;
    }
}
