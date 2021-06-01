package com.mf;

import com.mf.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Autowired
    UserServiceImpl userService;
    @Test
    void test(){
        System.out.println(userService.queryUserByName("张三"));
    }


    @Test
    void contextLoads() {
    }

}
