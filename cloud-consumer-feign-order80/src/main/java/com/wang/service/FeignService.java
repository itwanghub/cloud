package com.wang.service;

import com.wang.entity.CommonResult;
import com.wang.entity.Payment;
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
@FeignClient("CLOUD-PAYMENT-SERVER")
public interface FeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Integer id);
}
