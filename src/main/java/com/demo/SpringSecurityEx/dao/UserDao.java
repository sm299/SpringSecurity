package com.demo.SpringSecurityEx.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.demo.SpringSecurityEx.pojo.User;

@Repository
public class UserDao {
    static List<User> userList = new ArrayList<>();
    static {
        User usr1 = new User();
        usr1.setUsername("Shreya");
        usr1.setPassWord("S@299");
        userList.add(usr1);

        User usr2 = new User();
        usr2.setUsername("Soumik");
        usr2.setPassWord("S@299");
        userList.add(usr2);

    }

    public Optional<User> getUserByName(String name) {
        // Optional<User> user = Optional.ofNullable(new User());
        return userList.stream().filter(usr -> usr.getUsername().equalsIgnoreCase(name))
                .findFirst();
        // return user;
    }

    public User save(User user) {
        userList.add(user);
        return user;
    }
}
