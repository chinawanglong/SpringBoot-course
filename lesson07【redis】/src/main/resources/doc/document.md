# Spring Boot 集成Redis

1.导入依赖

```
 <!--引入redis依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<!--阿里巴巴的fastjson-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.66</version>
</dependency>
```
 导入阿里巴巴的fastjson是为了后面存储实体，方便把实体转换为json字符串
 
 2.application.yml配置
 
 ```
server:
  port: 8080

spring:
  redis:
    database: 1
    # 配置redis的主机地址
    host: localhost
    port: 6379
    password:
    timeout: 5000
    jedis:
      pool:
        # 连接池的最大空闲连接，默认值是8
        max-idle: 500
        # 连接池最小空闲连接，默认值是0
        min-idle: 50
        # 如果赋值-1，则表示不限制
        max-active: 1000
        # 等待可用连接的最大时间，单位毫秒。如果超过等待时间，则直接抛出JedisConnectionException
        max-wait: 2000
```

3.redisService 

> redis: String
```java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * set redis: string类型
     * @param key
     * @param value
     */
    public void setString(String key, String value){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    /**
     * get redis: string类型
     * @param key
     * @return
     */
    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}
```

```java
package com.example.demo;

import com.example.demo.service.RedisService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class Lesson07ApplicationTests {

    @Autowired
    private RedisService redisService;
    @Test
    void contextLoads() {
        // 测试redis的String类型
        redisService.setString("profession", "java程序员");
        log.info("我的职业:{}", redisService.getString("profession"));
    }

}
```

> redis: hash

```java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * set redis: hash类型
     * @param key
     * @param filedKey
     * @param value
     */
    public void setHash(String key, String filedKey, String value){
        HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put(key, filedKey, value);
    }

    /**
     * get redis: hash类型
     * @param key
     * @param filedKey
     * @return
     */
    public String getHash(String key, String filedKey){
        return (String) stringRedisTemplate.opsForHash().get(key, filedKey);
    }
}
```

```java
package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import com.example.demo.service.RedisService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class Lesson07ApplicationTests {

    @Autowired
    private RedisService redisService;
    @Autowired
    private User user;
    @Test
    void contextLoads() {
        user.setName("elliot");
        // 测试redis的hash类型
        redisService.setHash("user", "name", JSON.toJSONString(user));
        log.info("用户姓名:{}", redisService.getHash("user","name"));
    }
}
```

> redis: list

```java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * set redis: list
     * @param key
     * @param value
     * @return
     */
    public Long setList(String key, String value){
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        return listOperations.leftPush(key, value);
    }

    /**
     * get redis: list
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> getList(String key, long start, long end){
        return stringRedisTemplate.opsForList().range(key, start, end);
    }
}
```

```java
package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.RedisService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
class Lesson07ApplicationTests {

    @Autowired
    private RedisService redisService;
    
    @Test
    void contextLoads() {
        user.setName("elliot");
        // 测试redis的hash类型
        redisService.setList("list", "football");
        redisService.setList("list", "basketball");
        List<String> valList = redisService.getList("list", 0, -1);
        for (String val: valList){
            log.info("list中有: {}", val);
        }
    }
}
```


 