package lesson15.demo.service;

import lesson15.demo.entity.User;

/**
 * @author elliot
 */
public interface IUserService {

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 删除用户
     * @param ids
     */
    void deleteUser(String ids);
}
