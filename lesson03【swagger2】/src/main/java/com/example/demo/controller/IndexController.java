package com.example.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api("在线接口文档测试")
public class IndexController {
    @GetMapping("index")
    @ApiOperation("浏览器打印 hello world")
    public String index(){
        return "hello world";
    }
}
