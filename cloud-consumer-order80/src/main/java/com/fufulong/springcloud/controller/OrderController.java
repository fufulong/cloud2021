package com.fufulong.springcloud.controller;

import com.fufulong.springcloud.entities.CommonResult;
import com.fufulong.springcloud.entities.paymentModule.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/customer")
public class OrderController {

    //远程调用的 地址
    public static final String PAYMENY_URL = "http://cloud-provider-service";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create (@RequestBody Payment payment){
        /**
         param1 请求地址，param2 请求参数， param3 返回类型
         */
        return restTemplate.postForObject(PAYMENY_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENY_URL + "/payment/get/" + id, CommonResult.class);
    }
}
