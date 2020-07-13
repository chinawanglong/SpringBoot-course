package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_persimission")
public class Permission {
    private Integer id;
    private String persimissonname;
    private Integer roleId;
}
