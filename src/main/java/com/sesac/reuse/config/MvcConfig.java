package com.sesac.reuse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("/index");
        registry.addViewController("/").setViewName("/user/index");
        registry.addViewController("/index").setViewName("/user/index");
//        registry.addViewController("/user/login").setViewName("/user/login");
//        registry.addViewController("/user/signup").setViewName("/user/signup");
    }
}
