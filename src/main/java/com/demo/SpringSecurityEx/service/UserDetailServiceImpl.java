package com.demo.SpringSecurityEx.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.SpringSecurityEx.dao.UserDao;
import com.demo.SpringSecurityEx.pojo.User;
import com.demo.SpringSecurityEx.pojo.UserPrinciple;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = dao.getUserByName(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("UserName not found");
        }
        return new UserPrinciple(user.get());
    }

}
