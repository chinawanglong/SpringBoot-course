package com.example.lesson02.controller;

import com.example.lesson02.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 前端参数的接收
 */
@RestController
@RequestMapping("/")
public class GetParamController {

    /**
     * 获取RESTful风格的url参数 localhost:8080/hello/elliot
     * @param name
     * @return
     */
    @GetMapping("/hello/{name}")
    public String getResutfulParam(@PathVariable("name") String name){
        return "接收的参数 name:" + name;
    }


    /**
     * "？"后面的参数形式  localhost:8080/getParam?name=elliot&age=20
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/getParam")
    public String getParam(String name, Integer age){
        return "接收的参数  name:" + name + "\n age:" + age;
    }

    /**
     * 默认参数
     * @param name
     * @param age
     * @return
     */
    @GetMapping("defaultParam")
    public String getDefaultParam(
            @RequestParam(value = "name", defaultValue = "elliot") String name,
            @RequestParam(value = "age", defaultValue = "20") Integer age
    ){
        return "获取的参数 name:" + name + "\n age:" + age;
    }

    /**
     * 使用map接收所有参数 localhost:8080/mapParam?name=elliot&age=20
     * @param map
     * @return
     */
    @GetMapping("mapParam")
    public String mapParam(@RequestParam Map<String, Object> map){
        return "接收的参数 name:" + map.get("name") + "\n age:" + map.get("age");
    }

    /**
     * 接收一个数组 localhost:8080/arrayParam?name=elliot&name=wang
     * @param names
     * @return
     */
    @GetMapping("/arrayParam")
    public String arrayParam(@RequestParam("name") String[] names){
        String name = "";
        for (String param:names) {
            name += param + "\n";
        }
        return "获取的参数 name: " + name;
    }

    /**
     * 使用对象接收参数 localhost:8080/objectParam?name=elliot&age=20
     * @param user
     * @return
     */
    @GetMapping("objectParam")
    public String userObjectParam(User user){
        String name = user.getName();
        Integer age = user.getAge();
        return "获取的参数 name:" + name + "\n age:" + age;
    }


}
