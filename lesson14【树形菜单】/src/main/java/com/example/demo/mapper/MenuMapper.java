package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 * @author elliot
 */
@Mapper
@Repository
public interface MenuMapper {

    /**
     * 根据菜单类型获取树形菜单
     * @param menuType
     * @return
     */
    List<Menu> findByMenuType(Integer menuType);

    /**
     * 根据菜单Pid获取菜单
     * @param menuId
     * @return
     */
    List<Menu> findByMenuPid(Long menuId);
}
