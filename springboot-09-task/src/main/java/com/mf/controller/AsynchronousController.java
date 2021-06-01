package com.mf.controller;

import com.mf.service.AsynchronousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableAsync//开启异步注解功能
@RestController
public class AsynchronousController {
    @Autowired
    AsynchronousService asynchronousService;
    @GetMapping("/delay")
    public String delay() throws InterruptedException {
        asynchronousService.delay();
        return "延迟了两秒";
    }
}
