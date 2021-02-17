package com.fufulong.springcloud.controller;

import com.fufulong.springcloud.entities.CommonResult;
import com.fufulong.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public String getPaymentById(@PathVariable(name = "id") Long id){

        return paymentService.getPaymentById(id);
    }

    @GetMapping("/payment/hystrix/get/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){
        log.info("paymentInfo_OKKKKOKKK");
        return paymentService.paymentinfo_Ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        log.info("paymentInfo_timeout");
        return paymentService.paymentinfo_Timeout(id);
    }

    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }

    /**
     * 测试 getAway网关的接口
     * @param id
     * @return
     */
    @GetMapping("/payment/lb/{id}")
    public String paymentlb(@PathVariable("id") Integer id ){
        return "执行了服务提供者8001的paymentlb, id = " +id;
    }
}
