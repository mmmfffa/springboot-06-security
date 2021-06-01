package com.mf.controler;

import com.mf.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
        //具体的业务
        if ("admin".equals(username)&&"123".equals(password)){
            session.setAttribute("userSession",username);
            return "redirect:/main.html";
        }
        else{
            model.addAttribute("error","用户名或密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/main.html";
    }
}
