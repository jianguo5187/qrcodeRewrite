package com.qrcode.rewrite.service.impl;

import com.qrcode.rewrite.mapper.UserMapper;
import com.qrcode.rewrite.pojo.User;
import com.qrcode.rewrite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String userId){
        return userMapper.getUserInfo(userId);
    }
}
