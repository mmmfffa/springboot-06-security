package com.mf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2//开启swagger
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("刘邦");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("项羽");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("虞姬");
    }

    @Bean//配置swagger的Docket的bean实例
    public Docket getDocket(Environment environment){

        Profiles profiles=Profiles.of("dev");//设置要显示的swagger环境
        //获取项目的环境，通过environment.acceptsProfiles监听环境是否处在自己设定的环境当中
        boolean b = environment.acceptsProfiles(profiles);
        System.out.println("environment.acceptsProfiles==>"+b);
        return new Docket(DocumentationType.SWAGGER_2)
                   .apiInfo(getApiInfo())
                   .groupName("韩信")
                   .enable(b)
                   .select()
                   //配置要扫描接口的方式  RequestHandlerSelectors
                   .apis(RequestHandlerSelectors.basePackage("com.mf.controller"))
                   //.paths(PathSelectors.ant("/mf/**"))   //过滤
                   .build();
    }
    //配置swagger信息apiInfo
    private ApiInfo getApiInfo(){
        //作者信息
        Contact DEFAULT_CONTACT = new Contact("淮阴侯", "", "");
        return new ApiInfo("韩信的API文档",
                      "长枪一战",
                         "1.0",
                 "urn:tos",
                                 DEFAULT_CONTACT,
                          "Apache 2.0",
                        "http://www.apache.org/licenses/LICENSE-2.0",
                                  new ArrayList());
    }

}
