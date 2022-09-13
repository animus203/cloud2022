package com.ludens.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {
    @Bean       //用于开启Feign日志
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
