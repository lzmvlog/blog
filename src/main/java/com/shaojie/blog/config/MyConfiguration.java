//package com.shaojie.blog.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
// * @author ShaoJie
// * @Date 2019/10/6
// */
//@Configuration
//public class MyConfiguration extends WebMvcConfigurationSupport {
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
//    }
//
//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//        // 配置起始访问页面
//        registry.addViewController("/").setViewName("/index.html");
//    }
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        // 配置排除的静态文件 路径
//        String[] excludePathPatterns = {
//                "/static/**",
//                "/webjars/**",
//                "/",
//                "favicon.ico"
//        };
//
//        // 配置静态文件地址
//        String[] staticResourceLocations = {
//                "classpath:/static/",
//                "classpath:/META-INF/resources/webjars/",
//                "classpath:/META-INF/resources/",
//                "favicon.ico"
//        };
//
//        registry.addResourceHandler(excludePathPatterns)
//                .addResourceLocations(staticResourceLocations);
//    }
//}
