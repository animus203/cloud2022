package com.ludens.springcloud.service;

import com.ludens.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService1 {
    //写入
    public int create(Payment payment);

    //读取
    public Payment getPaymentById(@Param("id") Long id);
}
