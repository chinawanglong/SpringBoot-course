[toc]

## Log4j2

1.引入依赖，SpringBoot自带logback日志依赖，使用log4j2之前需要将其排除，防止冲突

```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
   <exclusions>
       <exclusion>
            <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-logging</artifactId>
      </exclusion>
  </exclusions>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>

```

2. log4j2-spring.xml 日志的配置文件


3.使用

```java
import lombok.extern.log4j.Log4j2;@Log4j2
public class LogController{
    public String log(){
        log.error("this is an error message");
        return null;
    }
}
```