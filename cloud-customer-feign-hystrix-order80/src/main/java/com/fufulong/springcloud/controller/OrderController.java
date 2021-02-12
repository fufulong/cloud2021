package com.fufulong.springcloud.controller;

import com.fufulong.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PaymentService paymentService;



    @GetMapping("/customer/feign/payment/get/{id}")
    public String getPaymentById(@PathVariable("id")Long id){
//        return restTemplate.getForObject(PAYMENY_URL + "/payment/get/" + id, CommonResult.class);
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/customer/payment/hystrix/get/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){
        log.info("消费者调用 paymentInfo_OK 方法,id=" + id);
        return paymentService.paymentInfo_OK(id);
    }
    @GetMapping("/customer/payment/hystrix/timeout/{id}")
  /*  @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        log.info("消费者调用 paymentInfo_Timeout 方法,id=" + id + ",现在的时间:"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return paymentService.paymentInfo_Timeout(id);
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        log.info("消费者调用 paymentInfo_TimeoutHandler 方法,id=" + id);
        return paymentService.paymentInfo_Timeout(id);
    }

}
