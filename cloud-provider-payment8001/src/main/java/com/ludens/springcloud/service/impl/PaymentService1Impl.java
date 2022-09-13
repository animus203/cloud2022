package com.ludens.springcloud.service.impl;

import com.ludens.springcloud.dao.PaymentDao1;
import com.ludens.springcloud.entities.Payment;
import com.ludens.springcloud.service.PaymentService1;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService1Impl implements PaymentService1 {
    @Resource
    private PaymentDao1 paymentDao1;

    //写入
    public int create(Payment payment){
        return paymentDao1.create(payment);
    }

    //读取
    public Payment getPaymentById(@Param("id") Long id) {

        return paymentDao1.getPaymentById(id);
    }
}
