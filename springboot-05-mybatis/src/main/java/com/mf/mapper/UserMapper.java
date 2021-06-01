package com.mf.mapper;

import com.mf.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//表示这是一个Mybatis接口
@Repository
public interface UserMapper {

    List<User> queryUserList();
    User queryUserById(int id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(int id);

}
