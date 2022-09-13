package com.ludens.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${info.age}")
    private String infoAge;

    @RequestMapping("/getServerPort")
    public String getServerPort() {
        return infoAge;
    }
}
