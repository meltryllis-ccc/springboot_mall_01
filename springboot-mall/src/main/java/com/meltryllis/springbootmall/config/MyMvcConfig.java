package com.meltryllis.springbootmall.config;

import com.meltryllis.springbootmall.component.LoginHandlerInterceptor;
import com.meltryllis.springbootmall.component.MyLocaleResolver;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * @author Ereshkigal
 * @date 2019/9/26 - 14:53
 */

//使用WebMvcConfigurer可以扩展springMVC的功能
@Configuration
//@EnableWebMvc     //全面接管springMVC配置，自动配置失效
public class MyMvcConfig implements WebMvcConfigurer {

    //所有的WebMvcConfigurer组件都会一起起作用
    @Bean   //一定要将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer figurur = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源; *.css , *.js
                //SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
            }
        };
        return figurur;
    }

    //把自定义的LocaleResolver添加到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


    @Bean
    public MultipartConfigElement multipartConfigElement() {

        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("D:\\work_space\\springboot\\springboot-mall\\src\\main\\resources\\images");

        return factory.createMultipartConfig();
    }
}
