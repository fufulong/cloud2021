package com.fufulong.springcloud.controller;

import com.fufulong.springcloud.entities.CommonResult;
import com.fufulong.springcloud.entities.paymentModule.Payment;
import com.fufulong.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/customer")
@Slf4j
public class OrderController {

    //远程调用的 地址
//    public static final String PAYMENY_URL = "http://cloud-payment-service";
    @Autowired
    private PaymentService paymentService;

    @Resource
    private RestTemplate restTemplate;



    @GetMapping("/feign/payment/get/{id}")
    public String getPaymentById(@PathVariable("id")Long id){
//        return restTemplate.getForObject(PAYMENY_URL + "/payment/get/" + id, CommonResult.class);
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/payment/hystrix/get/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){
        log.info("消费者调用 paymentInfo_OK 方法,id=" + id);
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        log.info("消费者调用 paymentInfo_Timeout 方法,id=" + id);
        return paymentService.paymentInfo_Timeout(id);
    }

}
