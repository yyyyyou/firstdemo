package com.yao.service.impl;

import com.yao.bean.Student;
import com.yao.mapper.StudentMapper;
import com.yao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    public Student getS(int id){
        return studentMapper.getS(id);
    }

}
