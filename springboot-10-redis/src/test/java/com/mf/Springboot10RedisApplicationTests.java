package com.mf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mf.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot10RedisApplicationTests {

    @Autowired
    @Qualifier(value = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //opsForValue()操作字符串
        //opsForXxx  操作不同数据类型
        //除了基本的操作，我们常用的方法都可以直接操作，比如CRUD
        redisTemplate.opsForValue().set("myKey","Study Redis");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        //connection.flushDb();
        //connection.flushAll();
    }


    @Test
    void test01() throws JsonProcessingException {
        //真实开发一般使用json传递对象
        User user = new User("韩信", "999");
        String json = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",json);
    }





}
