package com.example.demo.controller;

import com.example.demo.config.JsonResultConfig;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @PostMapping("/login")
    public JsonResultConfig login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session
    ){

       if (username.isEmpty() || !"123456".equals(password)){
           return new JsonResultConfig("0","账号或密码错误");
       }

        return new JsonResultConfig("1","登陆成功");
    }
}
