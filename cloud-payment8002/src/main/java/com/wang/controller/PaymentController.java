package com.wang.controller;

import com.wang.entity.CommonResult;
import com.wang.entity.Payment;
import com.wang.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;//可以获取当前服务的详细信息，需要在启动类上增加@EnableDiscoveryClient注解支持

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

    @GetMapping(value = "/payment/info")
    public DiscoveryClient getServiceInfo(){
        List<String> services = discoveryClient.getServices();
        for(String service:services){
            log.info("服务名："+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for(ServiceInstance instance:instances){
            log.info("实例ID：{},实例IP：{}，实例端口：{}，实例地址：{}"
                    ,instance.getInstanceId(),instance.getHost(),instance.getPort(),instance.getUri());
        }
        return this.discoveryClient;
    }
}
