package com.zhengdf.config;

import com.zhengdf.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CorsConfig
 * @Description 跨域配置
 * @Author zhengdf
 * @Data 2020/5/16 17:07
 * @Version 1.0
 **/
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    private final TokenInterceptor tokenInterceptor;

    public CorsConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                .maxAge(3600);
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login");
    }

}
