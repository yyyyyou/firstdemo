package com.yao.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("User")
public class User {
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;

    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
