package com.wang.dao;

import com.wang.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName
 * @Description
 */

@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Integer id);
}
