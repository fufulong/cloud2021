package com.fufulong.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRules {

    @Bean
    public IRule randomRule(){
//        RoundRobinRule rule = new RoundRobinRule();
        RandomRule rule = new RandomRule();
//        WeightedResponseTimeRule rule = new WeightedResponseTimeRule();
        return rule;
    }
}
