package com.pentacle.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping({"/", "index"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "Hello shiro!");
        return "index";
    }

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/user/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("login")
    public String login(String username, String password, Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token); //执行登录方法，如果没有异常就说明 OK
            return "index";
        } catch (UnknownAccountException e) { //用户名不存在
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException ice) { //密码不存在
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }
}
