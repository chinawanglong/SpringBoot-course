package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(User user) throws Exception{
        if (null != user){
            userService.insertUser(user);
        } else {
            return "failure";
        }
        return "success";
    }

    @PostMapping("/save")
    public String saveUser(User user) throws Exception {
        if (null != user){
            userService.insertData(user);
        } else {
            return "failure";
        }
        return "success";
    }
}
