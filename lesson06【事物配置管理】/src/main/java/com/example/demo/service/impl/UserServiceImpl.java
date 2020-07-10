package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void insertUser(User user){
        // 插入数据
        userMapper.insertUser(user);
        // 手动抛出异常
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void insertData(User user){
        userMapper.insertUser(user);
    }
}
