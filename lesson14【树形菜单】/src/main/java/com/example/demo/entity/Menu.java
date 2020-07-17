package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author elliot
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_menu")
public class Menu {
    private Long id;
    private Long pid;
    private String menuName;
    private Integer menuType;
    @TableField(exist = false)
    private List<Menu> childMenus;
}
