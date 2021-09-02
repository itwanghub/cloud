package com.wang.hystrix.controller;

import com.wang.hystrix.service.HyService;
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

    @GetMapping("/payment/ok/{id}")
    public String get_ok(@PathVariable("id") String id){
        return hyService.ok(id);
    }

    @GetMapping("/payment/no/{id}")
    public String get_on(@PathVariable("id") String id){
        return hyService.no(id);
    }
}
