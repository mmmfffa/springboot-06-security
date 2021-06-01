package com.mf.service;

import com.mf.pojo.User;

public interface UserService {
    User queryUserByName(String username);
}
