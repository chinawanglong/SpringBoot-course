package com.example.demo.service;

import com.example.demo.entity.Menu;

import java.util.List;

/**
 * @author elliot
 */
public interface MenuService {
    /**
     * 根据菜单pid获取菜单
     * @param id
     * @return
     */
    List<Menu> findByMenuPid(Long id);

    /**
     * 根据类型查询 获取菜单列表
     * @param menuType
     * @return
     */
    List<Menu> findByMenuType(Integer menuType);

    /**
     * 根据类型查询 以树形展示
     * @param menuType
     * @return
     */
    List<Menu> findMenuTree(Integer menuType);
}
