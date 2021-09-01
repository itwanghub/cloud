package com.wang.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
public interface LoadBalancer {
    /**
     * 拿到可用服务列表，进而选出改用那个一服务（下标）
     * @param serviceInstances
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
