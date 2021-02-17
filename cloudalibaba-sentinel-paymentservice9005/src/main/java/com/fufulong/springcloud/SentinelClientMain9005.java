package com.fufulong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SentinelClientMain9005 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelClientMain9005.class,args);
    }
}
