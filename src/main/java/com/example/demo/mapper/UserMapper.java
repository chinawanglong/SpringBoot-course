package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper // 必须，不然SpringBoot扫描不到
@Repository
public interface UserMapper {
    List<User> findAll();
}
