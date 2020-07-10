package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    void insertUser(User user);
    
    void insertData(User user) throws Exception;
}
