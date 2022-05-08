package com.zhourup.zcourse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author zhourup
 * @date 2022/4/29 21:13
 */
@Configuration
@EnableSwagger2
public class ZCourseSwaggerConfig {

    /**
     * 配置Swagger的docket的bean实例
     *
     * @return
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("ZCourse")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhourup.zcourse.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("周如鹏", "https://zhourup.github.io", "zhourup@163.com");
        return new ApiInfo("ZCourse在线课堂SwaggerAPI文档",
                "ZCourse在线课堂开发ing",
                "v1.0",
                "https://zhourup.github.io",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
}
