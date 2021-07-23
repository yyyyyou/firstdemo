package com.yao.servlet;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/my"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
log.info("Filter开始工作");
filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
log.info("myFilter销毁");
    }
}
