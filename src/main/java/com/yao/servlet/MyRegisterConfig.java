package com.yao.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyRegisterConfig {
@Bean
public ServletRegistrationBean myServlet(){
    MyServlet Servlet = new MyServlet();
    return new ServletRegistrationBean(Servlet,"/my","/my2");

}
@Bean
public FilterRegistrationBean myFilter(){
    MyFilter myFilter = new MyFilter();
//    return new FilterRegistrationBean(myFilter,myServlet());
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);

    filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/my2","/css/*"));
    return  filterRegistrationBean;
}

@Bean
public ServletListenerRegistrationBean myListener(){

    MyListener myListener = new MyListener();
    return new ServletListenerRegistrationBean(myListener);

}
}

