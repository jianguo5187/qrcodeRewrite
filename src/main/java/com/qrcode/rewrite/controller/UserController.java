package com.qrcode.rewrite.controller;

import com.qrcode.rewrite.pojo.User;
import com.qrcode.rewrite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    public User getUserInfo(String userId){
        return userService.getUserInfo(userId);
    }

}
