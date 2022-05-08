package com.zhourup.zcourse.config;

import com.zhourup.zcourse.interceptor.ZCourseAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域配置
 *
 * @author zhourup
 * @date 2022/5/5 14:59
 */
@Configuration
public class ZCourseWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ZCourseAuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**");
    }
}
