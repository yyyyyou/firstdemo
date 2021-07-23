package com.yao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("junit5测试")
public class Junit5Test {


    @Test
    @DisplayName("简单断言")
    void testSimpleAssertions(){
        int cal = cal(2, 3);
        assertEquals(5,cal,"业务逻辑计算失败");
        Object o = new Object();
        Object o1 = new Object();
        assertSame(o,o);
    }

    @Test
    @DisplayName("zy==组合断言")
    void all(){
    assertAll("test",
            ()->assertTrue(true&&true),
            ()->assertEquals(1,1));
    }
    int cal(int a,int b){
        return a+b;
    }

}
