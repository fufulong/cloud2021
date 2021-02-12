package com.fufulong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustomerFeignMain80 {
    public static void main(String[] args) {

        SpringApplication.run(CustomerFeignMain80.class,args);
    }
}
