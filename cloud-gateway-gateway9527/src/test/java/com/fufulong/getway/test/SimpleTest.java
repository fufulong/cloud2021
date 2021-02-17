package com.fufulong.getway.test;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleTest {

    @Test
    public void test1(){
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = now.format(pattern);
        System.out.println(s);
        System.out.println(now);
    }
}
