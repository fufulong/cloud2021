package com.fufulong.springcloud;

import com.fufulong.myrule.MyRules;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
//经过测试,当使用注解的形式制定一个服务调用的负载规则的时候,去掉RestTemplate的注解@LoadBalanced再调用消费者的接口或会报错,
//@RibbonClient(name = "cloud-payment-service",configuration = MyRules.class)
public class Order80Main {
    public static void main(String[] args) {
        SpringApplication.run(Order80Main.class,args);
    }
}
