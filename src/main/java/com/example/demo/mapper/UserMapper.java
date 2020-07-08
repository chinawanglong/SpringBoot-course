package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 必须，不然SpringBoot扫描不到
public interface UserMapper {
    List<User> findAll();
}
