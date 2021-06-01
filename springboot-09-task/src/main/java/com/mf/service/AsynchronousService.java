package com.mf.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynchronousService {
    @Async    //告诉spring，这是一个异步方法
    public void delay() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("数据正在处理....");
    }
}
