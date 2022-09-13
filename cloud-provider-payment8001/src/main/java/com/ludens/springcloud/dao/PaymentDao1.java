package com.ludens.springcloud.dao;

import com.ludens.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao1 {
    //写入
    public int create(Payment payment);

    //读取
    public Payment getPaymentById(@Param("id") Long id);
}
