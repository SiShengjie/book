package com.tongji.book.config;

import com.tongji.book.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author: Shengjie Si
 * Date: 2019/7/29 21:41
 * Version: 1.0
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    private LoginHandlerInterceptor loginHandlerInterceptor;

    @Autowired
    public void setLoginHandlerInterceptor(LoginHandlerInterceptor loginHandlerInterceptor) {
        this.loginHandlerInterceptor = loginHandlerInterceptor;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //url映射到指定页面
        registry.addViewController("/").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有url（除了登录、注册和静态资源不拦）
        registry.addInterceptor(loginHandlerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/login.html",
                        "/toRegister", "/register",
                        "/css/**", "/js/**", "/images/**", "/bower_components/**", "/dist/**", "/plugins/**");
    }
}
