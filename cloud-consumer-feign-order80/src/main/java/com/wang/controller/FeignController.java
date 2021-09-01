package com.wang.controller;

import com.wang.entity.CommonResult;
import com.wang.entity.Payment;
import com.wang.service.FeignService;
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
public class FeignController {
    @Resource
    private FeignService feignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Integer id){
        return feignService.getPayment(id);
    }
}
