package com.ludens.springcloud.service;

import org.springframework.stereotype.Component;

//方法异常的话 私有的返回fallback由这个service统一处理
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "######## PaymentFallbackService fallback paymentInfo_OK YEE";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "######## PaymentFallbackService fallback paymentInfo_TimeOut NOOOO";
    }
}
