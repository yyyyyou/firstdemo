package com.yao;

import com.yao.bean.User;
import com.yao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class GuiguApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = userMapper.selectById(1);
        log.info("用户信息{}",user);
    }

}
