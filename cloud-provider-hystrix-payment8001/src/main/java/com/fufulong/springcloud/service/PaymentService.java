package com.fufulong.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService{

    public String getPaymentById(Long id)
    {
        return "getPaymentById...id= "+id;
    }

    /**
     * 可以正常访问的方法
     * @param id
     * @return
     */
    public String paymentinfo_Ok(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfo_OK，id:" + id;
    }

    /**
     超时访问的方法
     */
   /* @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandlere",commandProperties = {
            //设置峰值，超过 3 秒，就会调用兜底方法，这个时间也可以由feign控制
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })*/
    public String paymentinfo_Timeout(Integer id){
        int interTime = 5;
        try{
            TimeUnit.SECONDS.sleep(interTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfo_Timeout，id:" + id + "耗时" + interTime + "秒钟--";
    }

    /**
     * 访问超时的降级处理方法
     */
    public String paymentInfo_timeoutHandlere(Integer id ){
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfo_timeoutHandlere，id:" + id ;

    }
}
