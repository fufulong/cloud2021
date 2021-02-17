package com.fufulong.springcloud.messageConsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@EnableBinding(value = Sink.class)
public class MessageConsumer {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(value = Sink.INPUT )
    public void input(Message<String> message){
        MessageHeaders headers = message.getHeaders();
        Set<String> keySet = headers.keySet();
        System.out.println("消费者端口号" + serverPort + ",得到的消息体:" + message.getPayload());
//        System.out.println("***请求头如下**************");
       /* for (String headKey : keySet) {
            Object headValue = headers.get(headKey);
            System.out.println("key = " + headKey +",value = " + headValue);
        }*/
    }
}
