package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo())
                .select()
                // 指定要生成api接口的包路径，这里把controller作为包路径，生产所有controller中接口的文档
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建API文档的详细信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 标题
                .title("SpringBoot接口文档测试")
                // 描述
                .description("swagger2接口文档")
                // 联系人、联系方式
                .contact(new Contact("elliot", "wanglong.org.cn", "ycitwl@163.com"))
                // 版本
                .version("1.0")
                // 创建
                .build();
    }

}
