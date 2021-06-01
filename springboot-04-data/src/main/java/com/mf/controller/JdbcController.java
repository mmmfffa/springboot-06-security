package com.mf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //查询数据库的所有信息
    //没有实体类，如何获取数据库中的东西，Map？
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql="select * from tb_user";
        return jdbcTemplate.queryForList(sql);
    }
    @GetMapping("/addUser")
    public int addUser(){
        String sql="insert into tb_user(id,username,pwd) values (?,?,?)";
        //封装
        Object[] objects = new Object[3];
        objects[0]=4;
        objects[1]="韩信";
        objects[2]="039";
        return jdbcTemplate.update(sql,objects);
    }
    @GetMapping("/updateUser")
    public int updateUser(){
        String sql="update tb_user set pwd=? where id=?";
        Object[] objects = new Object[2];
        objects[0]="990";
        objects[1]="4";
        return jdbcTemplate.update(sql,objects);
    }

    @GetMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable("id")int id){
        String sql="delete from tb_user where id=?";
        return jdbcTemplate.update(sql,id);
    }


}
