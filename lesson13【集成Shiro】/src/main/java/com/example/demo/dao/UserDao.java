package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserDao {
    @Select("selct * from t_user where username = #{username}")
    User getByUsername(String username);

    @Select("select r.rolename from t_user u,t_role r where u.role_id = r.id and u.username = @{username}")
    Set<String> getRoles(String username);

    @Select("select p.permissionname from t_user u,t_role r,t_permission p " +
            "where u.role_id = r.id and p.role_id = r.id and u.username = #{username}")
    Set<String> getPermission(String username);

}
