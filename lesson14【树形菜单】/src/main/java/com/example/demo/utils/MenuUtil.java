package com.example.demo.utils;

import com.example.demo.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 拼装菜单
 * @author elliot
 * @date 2019/07/17
 */
public class MenuUtil {
    public static List<Menu> getMenuTree(List<Menu> menusRoot){
        List<Menu> menusResult = new ArrayList<>();

        for (Menu menu:menusRoot){
            // 一级菜单， 加入menusResult中
            if (menu.getPid() == 0){
                menusResult.add(menu);
            }
        }

        // 对menusResult进行树形结构处理, 填充chileMenus
        for (Menu menu:menusResult){
            menu.setChildMenus(getChildTree(menu.getId(), menusRoot));
        }
        return menusResult;
    }

    /**
     * 获取菜单的子菜单
     * @param id
     * @param menusRoot
     * @return
     */
    public static List<Menu> getChildTree(Long id, List<Menu> menusRoot){
        List<Menu> menusChild = new ArrayList<>();

        // 同一id下的子菜单
        for (Menu menu : menusRoot){
            if (menu.getPid() != 0){
                if (menu.getPid().equals(id)){
                    menusChild.add(menu);
                }
            }
        }
        for (Menu menu:menusChild){
            if (menu.getPid() != 0){
                menu.setChildMenus(getChildTree(menu.getId(), menusRoot));
            }
        }
        if (menusChild.size() == 0){
            return null;
        }

        return menusChild;
    }
}
