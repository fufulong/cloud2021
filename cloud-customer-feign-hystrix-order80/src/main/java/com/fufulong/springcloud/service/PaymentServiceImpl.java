package com.fufulong.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String getPaymentById(Long id) {
        String result = "降级处理,执行PaymentServiceImpl的getPaymentById方法,id= " + id;
        log.info(result);
        return result;
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        String result = "降级处理,执行PaymentServiceImpl的paymentInfo_OK方法,id= " + id;
        log.info(result);
        return result;
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        String reult = "降级处理,执行PaymentServiceImpl的paymentInfo_Timeout方法,id= " + id+",现在的时间:"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info(reult);
        return reult;
    }
}
