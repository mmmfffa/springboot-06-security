package com.mf.mapper;

import com.mf.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper//表示这是一个Mybatis接口
@Repository
public interface UserMapper {
    User queryUserByName(String username);
}