package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单控制器
 * @author elliot
 */
@RestController
@RequestMapping("/admin")
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;

    @GetMapping("/menuList")
    public List<Menu> getMenuList(){
        return menuService.findMenuTree(0);
    }
}
