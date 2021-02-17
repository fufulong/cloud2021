package com.fufulong.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosPaymentController {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPaymentById(@PathVariable(value = "id") Integer id){
        return String.format("端口号 %s 的支付服务提供者的getPaymentById执行,id = %d",serverPort,id);
    }
}
