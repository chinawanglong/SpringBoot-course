package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import com.example.demo.service.RedisService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
class Lesson07ApplicationTests {

    @Autowired
    private RedisService redisService;
    @Autowired
    private User user;
    @Test
    void contextLoads() {
        user.setName("elliot");
        // 测试redis的hash类型
        redisService.setList("list", "football");
        redisService.setList("list", "basketball");
        List<String> valList = redisService.getList("list", 0, -1);
        for (String val: valList){
            log.info("list中有: {}", val);
        }
    }



}
