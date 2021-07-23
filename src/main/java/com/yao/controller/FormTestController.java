package com.yao.controller;

import com.yao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * 文件上传
 */
@Controller
@Slf4j
public class FormTestController {

    @Autowired
    UserService userService;


    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile自动封装上传来的文件
     * @param email
     * @param uname
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public  String upload(@RequestParam("email") String email,
                          @RequestParam("username") String uname,
                          @RequestPart("headerImg") MultipartFile headerImg,
                          @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={}, username={}, headerImg={}, photos={}",
                email,uname,headerImg.getSize(),photos.length);
        if (!headerImg.isEmpty()){
            //保存到文件服务器  oss 服务器
            String filename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\java文件\\"+filename));
        }
        if (photos.length>0){
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()){
                    String filename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\java文件\\"+filename));
                }

            }
        }

      //  System.out.println(email+uname);
        return "main";
    }

}
