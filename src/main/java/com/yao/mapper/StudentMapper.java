package com.yao.mapper;

import com.yao.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository//dao层的注解
public interface StudentMapper {

     Student getS(int id);
}
