package com.wang.controller;

import com.wang.entity.CommonResult;
import com.wang.entity.Payment;
import com.wang.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result>0){
            log.info("插入成功:{}！，参数：{}",result,payment.getSerial());
            return new CommonResult(200,"插入成功,端口号："+serverPort,result);
        }else {
            log.info("插入失败！",result);
            return new CommonResult(444,"插入失败!");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult selectById(@PathVariable("id") Integer id){
        Payment payment = paymentService.getPaymentById(id);
        if (null!=payment){
            log.info("插入成功！");
            return new CommonResult(200,"查询成功,端口号："+serverPort,payment);
        }else {
            return new CommonResult(444,"没有找到ID:"+id);
        }
    }
}
