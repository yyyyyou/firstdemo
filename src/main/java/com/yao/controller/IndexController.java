package com.yao.controller;

import com.yao.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    /**
     * 来登录页面
     * @return
     */

    @GetMapping(value = {"/","/login"})
    public String toLoginPage(){

        return "login";
    }

    /**
     * 登录成功  重定向到main 页面
     * @return
     */
    @PostMapping("login")
    public String  main(User user, HttpSession session, Model model){
        if (!StringUtils.isEmpty(user.getUsername())&&"123456".equals(user.getPassword())){
           //把登陆的用户保存起来
            session.setAttribute("userSession",user);
            System.out.println(user);
            return "redirect:main.html";
        }
        else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/main.html")
    public String toMainPage(HttpSession session,Model model){
        Object userSession = session.getAttribute("userSession");
        if (userSession!=null){
            return "main";
        }else {
            model.addAttribute("msg","请登录");
            return "login";
        }

    }
}
