package com.mf.controller;

import com.mf.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/test")
    public String test1(){
        return "SpringBoot-Swagger";
    }
    //只要我们的接口返回值中存在实体类，就会被扫描
    @PostMapping(value = "/user")
    public User test2(){
        return new User();
    }

    @ApiOperation("hello控制类")
    @GetMapping("/hello")
    public String hello(@ApiParam("用户名") String username){
        return "hello"+username;
    }
}
