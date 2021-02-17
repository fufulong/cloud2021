package com.fufulong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SentinelClient9004Main {

    public static void main(String[] args) {
        SpringApplication.run(SentinelClient9004Main.class,args);
    }
}
