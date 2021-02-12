package com.fufulong.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentService {

    //这个就是provider 的controller层的方法定义。
    @GetMapping(value = "/payment/get/{id}")
    public String getPaymentById(@PathVariable("id")Long id);


    @GetMapping("/payment/hystrix/get/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id);

}
