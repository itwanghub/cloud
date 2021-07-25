package com.wang.service;

import com.wang.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */
public interface IPaymentService {

    int create(Payment payment);

    Payment getPaymentById(Integer id);
}
