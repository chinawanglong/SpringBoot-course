package lesson15.demo.controller;

import lesson15.demo.config.JsonResult;
import lesson15.demo.entity.User;
import lesson15.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author elliot
 * @date 2020-08-04
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {

//    @Autowired
//    private IUserService userService;

    private final IUserService userService;

    /**
     * 构造器依赖注入
     * @param userService
     */
    @Autowired
    public UserController(IUserService userService){
        this.userService = userService;
    }



    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    public JsonResult saveUser(User user){
        userService.saveUser(user);
        return JsonResult.success();
    }

    /**
     * 删除用户
     * @param ids
     * @return
     */
    @PostMapping("/deleteUser")
    public JsonResult deleteUser(@RequestParam("ids") String ids){
        userService.deleteUser(ids);
        return JsonResult.success();
    }



}
