package com.example.demo.service;


import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getByUsername(String username){
        return userDao.getByUsername(username);
    }

    public Set<String> getRoles(String username){
        return userDao.getRoles(username);
    }

    public Set<String> getPermissions(String username){
        return userDao.getPermission(username);
    }
}
