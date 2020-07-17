package com.example.demo.service.impl;

import com.example.demo.entity.Menu;
import com.example.demo.mapper.MenuMapper;
import com.example.demo.service.MenuService;
import com.example.demo.utils.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author elliot
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    /**
     * 根据菜单pid获取菜单
     *
     * @param id
     * @return
     */
    @Override
    public List<Menu> findByMenuPid(Long id) {
        return menuMapper.findByMenuPid(id);
    }

    /**
     * 根据类型查询 获取菜单列表
     *
     * @param menuType
     * @return
     */
    @Override
    public List<Menu> findByMenuType(Integer menuType) {
        return menuMapper.findByMenuType(menuType);
    }


    /**
     * 根据类型查询 以树形展示
     *
     * @param menuType
     * @return
     */
    @Override
    public List<Menu> findMenuTree(Integer menuType) {
        List<Menu> menuList = menuMapper.findByMenuType(menuType);
        return MenuUtil.getMenuTree(menuList);
    }
}
