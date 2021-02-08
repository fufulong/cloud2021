package com.fufulong.springcloud.service;

import com.fufulong.springcloud.entities.paymentModule.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public Integer create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
