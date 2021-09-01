package com.wang.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
@Component
public class MyLB implements LoadBalancer {

    //原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    // 获取当前是第几次请求
    private final int getIncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0:current+1;//int 类型最大值
            //当前值和初始值比较，当前值如果=初始值则更新初始值为+1后的值，并返回true
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("**********"+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
