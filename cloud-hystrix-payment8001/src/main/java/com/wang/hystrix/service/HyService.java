package com.wang.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@Service
public class HyService {
    @Value("${server.port}")
    private String serverPort;

    public String ok(String id){
        return "正常服务！"+ UUID.randomUUID().toString()+"  ID:"+id;
    }

    @HystrixCommand(fallbackMethod = "error_handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String no(String id){
        int timeOut = 5000;
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "超时服务！"+ UUID.randomUUID().toString()+"  ID:"+id+"超时时间:"+timeOut;
    }

    public String error_handler(String id){
        return "服务器开小差了！-->"+id;
    }

}
