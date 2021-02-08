package com.fufulong.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping(value = "/consul")
    public String paymentConsul(){
        String result = "注册在consul的paymentController运行,port =" + port + "," + UUID.randomUUID() ;
        return result;
    }
}
