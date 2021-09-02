package com.wang.hystrix.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@Component
@FeignClient("CLOUD-HYSTRIX-PAYMENT")
public interface HyService {
    @GetMapping("/payment/ok/{id}")
    String get_ok(@PathVariable("id") String id);

    @GetMapping("/payment/no/{id}")
    public String get_on(@PathVariable("id") String id);
}
