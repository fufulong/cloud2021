package com.fufulong.springcloud.controller;

import com.fufulong.springcloud.entities.CommonResult;
import com.fufulong.springcloud.entities.paymentModule.Payment;
import com.fufulong.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;


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
        log.info("模拟支付查询服务出现请求超时,线程睡眠6秒钟..");
        try {
            Thread.currentThread().sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment result = paymentService.getPaymentById(id);
        log.info("****查询结果：" + result);
        if(result != null){

            return new CommonResult<>(200, "查询成功,server-port: 8001" , result);
        }
        return new CommonResult<>(200, "没有对应id的记录", null);
    }


    @GetMapping(value = "/discoverClient")
    public Object discoverClientTest(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service + "\t");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++");
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-service");
        for (ServiceInstance instance : instances) {
            log.info(String.format("实例id: %s\t实例host:%s\t实例port:%s\t实例uri:%s\n",
                    instance.getInstanceId(),instance.getHost(),instance.getPort(),instance.getUri()));
        }
        return discoveryClient;

    }

}
