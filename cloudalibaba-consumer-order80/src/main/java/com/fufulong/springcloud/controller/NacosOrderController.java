package com.fufulong.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosOrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-payment-service}")
    private String paymentServiceUrl;

    @GetMapping(value = "/customer/nacos/payment/{id}")
    public String getOrderId(@PathVariable("id") Integer id){
        return restTemplate.getForObject(paymentServiceUrl + "/payment/nacos/" + id,String.class);
    }
}
