package lesson15.demo.service.impl;

import lesson15.demo.entity.User;
import lesson15.demo.mapper.UserMapper;
import lesson15.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 用户对象操作
 * @author elliot
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 保存用户
     *
     * @param user
     */
    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    /**
     * 删除用户
     *
     * @param ids
     */
    @Override
    public void deleteUser(String ids) {
        if (null == ids){
            throw new RuntimeException("缺少必要参数");
        }
        List<String> idArr = Arrays.asList(ids.split(","));
        userMapper.deleteBatchIds(idArr);
    }
}
