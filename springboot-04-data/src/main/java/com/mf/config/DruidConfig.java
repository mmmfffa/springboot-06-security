package com.mf.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    //后台监控：相当于web.xml  ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要，有人登陆，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername","root");//loginUsername固定
        initParameters.put("loginPassword","123456");
        //允许谁访问
        initParameters.put("allow","");
        //禁止谁能访问initParameters.put("用户名","IP地址")

        bean.setInitParameters(initParameters);
        return bean;
    }

    //过滤
    @Bean
    public FilterRegistrationBean webStartFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        //设置阿里巴巴过滤器
        bean.setFilter(new WebStatFilter());
        //过滤那些请求
        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions","*.js,*css,*img,/druid/*");//这些东西不进行统计


        bean.setInitParameters(initParameters);
        return bean;
    }



}
