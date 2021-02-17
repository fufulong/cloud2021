package com.fufulong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GetAwayServerMain {

    public static void main(String[] args) {
        SpringApplication.run(GetAwayServerMain.class,args);
    }
}
