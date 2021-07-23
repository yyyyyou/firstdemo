package com.yao.controller;

import com.yao.bean.Student;
import com.yao.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/stu")
    public Student gets(@RequestParam("id") int id){
        Student s = studentService.getS(id);
        return s;
    }

    @GetMapping("/stu2")
    public String gets(){
        return "123";
    }
}
