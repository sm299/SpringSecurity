package com.demo.SpringSecurityEx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringSecurityEx.dao.UserDao;
import com.demo.SpringSecurityEx.pojo.User;

@RestController
public class UserController {
    @Autowired
    UserDao dao;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public User registUser(User user) {
        user.setPassWord(encoder.encode(user.getPassWord()));
        dao.save(user);
        return user;
    }

}
