[toc]

## SpringBoot整合mybatis

1. 引入依赖

```
<!--mybatis依赖-->
<dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.3.2</version>
</dependency>
<!--数据库链接依赖-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

2.application.yml文件配置

```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC
    username: root
    password: elliot@mysql

mybatis:
  type-aliases-package: com.example.demo.entity # 指定别名设置的包为所有entity
  mapper-locations: classpath:mapper/*.xml # mapper映射文件位置

```

3.使用

参考
controller->service->serviceImpl

entity->mapper->mapper.xml