package com.ludens.springcloud.controller;

import com.ludens.springcloud.entities.CommonResult;
import com.ludens.springcloud.entities.Payment;
import com.ludens.springcloud.service.PaymentService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController1 {
    @Resource       //初始化时将实例注入应用
    private PaymentService1 paymentService1;

    //eureka服务发现
    @Resource
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        //RequestBody注解的主要作用就是用于接收前端的参数，当我们使用post请求的时候，
        //我们会将参数放在request body中，此时我们就需要在Controller的方法的参数前面加上@RequestBody用来接受到前端传过来的request body中的值
        int result = paymentService1.create(payment);
        log.info("*****插入结果："+ result);
        if(result >0){
            return new CommonResult(200, "插入数据库成功，serverport："+ serverPort, result);
        } else{
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService1.getPaymentById(id);
        log.info("*****查询结果："+ payment);
        if(payment != null){
            return new CommonResult(200, "查询成功，serverport：" + serverPort, payment);
        } else{
            return new CommonResult(444, "查询失败", null);
        }
    }

    //得到微服务的各种信息
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*****element: "+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() +"\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    //测试OpenFeign的超时
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
