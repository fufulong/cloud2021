package com.fufulong.springcloud.messageProvider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(value = Source.class)
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        log.info("serial:" + serial);
        boolean sendResult = output.send(MessageBuilder.withPayload(serial).build());
        return String.format("是否发送成功: %s,发送的信息: %s",sendResult,serial);
    }
}
