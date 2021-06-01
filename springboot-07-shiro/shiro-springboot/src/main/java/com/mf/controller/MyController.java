package com.mf.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping({"/index","/"})
    public String toIndex(Model model){
        model.addAttribute("msg","this is shiro-springboot!");
        return "index";
    }
    @RequestMapping("user/add")
    public String toAdd(){
        return "user/add";
    }
    @RequestMapping("user/update")
    public String toUpdate(){
        return "user/update";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        //1.获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户的登录数据
        UsernamePasswordToken passwordToken = new UsernamePasswordToken(username,password);
        //3.执行登录
        try {
            subject.login(passwordToken);
            return "index";
        } catch (UnknownAccountException uae) {//账户不对
            model.addAttribute("msg","用户不存在");
            return "login";
        } catch (IncorrectCredentialsException ice) {//密码不对
            model.addAttribute("msg","密码有误");
            return "login";
        }
    }
    @RequestMapping("/logout")
    public String toLogout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }
    @RequestMapping("/noAuth")
    @ResponseBody
    public String unauthorized(){
         return "未经授权无法访问";
    }
}
