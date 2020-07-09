package com.example.lesson02.controller;

import com.example.lesson02.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class PostParamController {

    /**
     * 1.controller接收form-data格式的POST数据
     *  localhost:8080/index/post1
     *  {name:elliot, age:20}
     * @param name
     * @param age
     * @return
     */
    @PostMapping("/post1")
    public String postParam(@RequestParam("name") String name, @RequestParam("age") Integer age){
        return "接收的参数 name:" + name + "\n age: " + age;
    }

    /**
     * 2.默认参数
     * @param name
     * @param age
     * @return
     */
    @PostMapping("/post2")
    public String defaultParam(
            @RequestParam(value = "name", defaultValue = "elliot") String name,
            @RequestParam(value = "age", defaultValue = "20") Integer age
    ){
        return "接收的参数 name:" + name + "\n age:" + age;
    }

    /**
     * 3.使用map接收所有参数
     * @param param
     * @return
     */
    @PostMapping("/post3")
    public String mapParam(@RequestParam Map<String, Object> param){
        return "接收的参数 name:" + param.get("name") + "\n age:" + param.get("age");
    }

    /**
     * 4.接收一个数组
     * @param names
     * @return
     */
    @PostMapping("/post4")
    public String arrayParam(@RequestParam("name") String[] names){
        String result = "";
        for (String name:names){
            result += name + "\n";
        }
        return result;
    }

    /**
     * 5.使用对象来接收参数
     * @param user
     * @return
     */
    @PostMapping("/post5")
    public String objectParam(User user){
        return "接收的参数 name:" + user.getName() + "\n age:" + user.getAge();
    }

    /**
     * 6.接收字符串文本数据
     * @param request
     * @return
     */
    @PostMapping("/post6")
    public  String stringParam(HttpServletRequest request){
        ServletInputStream is = null;
        try {
            is = request.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[1024];
            int len = 0;
            while((len = is.read(buf)) != -1){
                sb.append(new String(buf, 0 , len));
            }
            System.out.println(sb.toString());
            return "获取的文本内容为:" + sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (is != null){
                    is.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 7.接收Json数据
     * @param param
     * @return
     */
    @PostMapping("/post7")
    public String jsonParam(@RequestBody Map<String, Object> param){
        return "接收的参数 name:" + param.get("name") + "\n age:" + param.get("age");
    }

    // 8.使用Bean对象来接收数据
    @PostMapping("post8")
    public String beanParam(@RequestBody User user){
        return "接收的参数 name：" + user.getName() + "\n age:" + user.getAge();
    }

}
