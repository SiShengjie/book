package com.tongji.book.controller;

import com.alibaba.fastjson.JSON;
import com.tongji.book.entity.User;
import com.tongji.book.service.UserService;
import com.tongji.book.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 登录拦截器
 * Author: Shengjie Si
 * Date: 2019/7/30 22:33
 * Version: 1.0
 */
@Controller
@Slf4j
public class LoginController {

    private UserService userService;
    static int loginCount = 0;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String userPassword,
                        Map<String, Object> map,
                        HttpSession httpSession) {
        User user = userService.authorizeUser(userName, Md5Util.md5Encrypt(userPassword));
        if (user != null) {
            loginCount++;//登陆成功，计数加一
            httpSession.setAttribute("user", user);
            return "redirect:/index";
        } else {
            map.put("msg", "用户名或密码错误！");
            return "login";
        }
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public boolean register(@RequestParam("userStr") String userStr) {
        String userName = JSON.parseObject(userStr).getString("userName");
        if(userService.exitsUserName(userName)){
            log.info("已存在用户名为：\""+userName+"\"的用户，注册失败！");
            return false;
        }
        return userService.save(userStr);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "redirect:/";
    }
}
