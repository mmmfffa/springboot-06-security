package com.mf.controller;


import com.mf.mapper.UserMapper;
import com.mf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        return userMapper.queryUserList();
    }
    @GetMapping("/queryUserById")
    public User queryUserById(int id){
        return userMapper.queryUserById(id);
    }
    @GetMapping("/addUser")
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    @GetMapping("/updateUser")
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }
    @GetMapping("/deleteUserById")
    public int deleteUserById(int id){
        return userMapper.deleteUserById(id);
    }

}
