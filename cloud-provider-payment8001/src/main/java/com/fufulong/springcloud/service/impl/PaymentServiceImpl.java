package com.fufulong.springcloud.service.impl;

import com.fufulong.springcloud.dao.PaymentMapper;
import com.fufulong.springcloud.entities.paymentModule.Payment;
import com.fufulong.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    public Integer create(Payment payment)
    {
        return paymentMapper.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentMapper.getPaymentById(id);
    }
}
