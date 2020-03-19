package com.atguigu.springcloud.service;

import org.apache.ibatis.annotations.Param;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author Road
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
