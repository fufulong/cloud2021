package com.fufulong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class NacosPaymentProvider9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentProvider9001.class,args);
    }
}
