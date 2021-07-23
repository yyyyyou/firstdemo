package com.yao.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yao.bean.User;
import com.yao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){
        int i=10/0;


        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
//        List<User> userList = Arrays.asList(new User("搞白气球", "123"),
//                new User("绿色气球", "1555"),
//                new User("蓝色气球", "133"),
//                new User("红色气球", "1222"),
//                new User("彩色气球", "1")
//        );
//        model.addAttribute("userList",userList);
        List<User> list = userService.list();
        System.out.println(list);
//        model.addAttribute("users",list);
        //分页查询记录
        Page<User> userPage = new Page<>(pn, 2);
        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page",page);
        return "table/dynamic_table";
    }
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn" ,defaultValue = "1") Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);
        ra.addAttribute("pn",pn);

        return "redirect:/dynamic_table";

    }
    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }
}
