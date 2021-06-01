package com.mf.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问.,但是对应功能需要权限
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/level1/**").hasRole("vip1")
            .antMatchers("/level2/**").hasRole("vip2")
            .antMatchers("/level3/**").hasRole("vip3");

        //没有权限默认会到登录页
        http.formLogin().loginPage("/toLogin");
        //开启了注销功能,跳到首页
        //防止网站攻击  get   csrf跨站请求攻击 登出失败可能的原因
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能  cookie
        http.rememberMe().rememberMeParameter("remember");

    }

    //认证  springboot2.1.x可以直接使用
    //密码编码：PasswordEncoder
    //在spring security5.0+新增加密很多加密方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
           //这些数据正常应该从内存中读取
            //从内存中验证
        	auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("mafu").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("333")).roles("vip1","vip2","vip3");
    }
}
