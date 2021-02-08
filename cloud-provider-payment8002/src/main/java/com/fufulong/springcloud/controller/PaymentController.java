package com.fufulong.springcloud.controller;

import com.fufulong.springcloud.entities.CommonResult;
import com.fufulong.springcloud.entities.paymentModule.Payment;
import com.fufulong.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        Integer result = paymentService.create(payment);
        log.info("******插入结果: " + result);
        if (result != null && result > 0 ){
            return new CommonResult(200,"插入成功");
        }

        return new CommonResult(500,"插入失败");
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value ="id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("****查询结果：" + result);
        if(result != null){

            return new CommonResult<>(200, "查询成功,server-port: 8002", result);
        }
        return new CommonResult<>(200, "没有对应id的记录", null);
    }


}
