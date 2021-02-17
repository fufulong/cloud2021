package com.fufulong.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class SentinelServerController {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping(value = "/sentinel/test1")
    public String sentinelTest1(){
        log.info("sentinel的端口:{}的服务端启动,执行了方法sentinelTest1........",serverPort);
        return String.format("sentinel的端口:%s的服务端启动,执行了方法sentinelTest1........",serverPort);
    }

    @GetMapping(value = "/sentinel/test2")
    public String sentinelTest2() throws InterruptedException {
        log.info("sentinel的端口:{}的服务端启动,执行了方法sentinelTest2........",serverPort);
//        Thread.currentThread().sleep(3000);
        return String.format("sentinel的端口:%s的服务端启动,执行了方法sentinelTest2.......",serverPort);
    }

    /**
     * 用来测试 sentinel的热点限流的接口
     * @param id
     * @param name
     * @return
     */
    @GetMapping(value = "/sentinel/test3")
    @SentinelResource(blockHandler = "sentinelTest3_blockHandler")
    public String sentinelTest3(@RequestParam(value = "id",required = false) Integer id ,
                                @RequestParam(value = "name",required = false) String name){
        log.info("端口是{}的sentinel客户端开始执行接口sentinelTest3,id={},name={}",serverPort,id,name);
        return "sentinelTest3(Integer id ,String name)执行成功.........";
    }

    public String sentinelTest3_blockHandler(Integer id ,String name){
        log.info("端口是{}的sentinel客户端开始执行 sentinelTest3_blockHandler,id={},name={}",serverPort,id,name);
        return "sentinelTest3_blockHandler(Integer id ,String name)执行成功.........";
    }



}
