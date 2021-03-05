package com.master.service.impl;

import com.master.mapper.UserMapper;
import com.master.pojo.User;
import com.master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Creqated by Limingxuan on 2021/3/3
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }
}
