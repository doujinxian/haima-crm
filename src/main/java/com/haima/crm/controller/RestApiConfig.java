package com.haima.crm.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jinxian.dou
 *
 */
@EnableWebMvc  
@EnableSwagger2
@ComponentScan(basePackages = {"com.haima.crm.controller"})  
@Configuration
public class RestApiConfig extends WebMvcConfigurationSupport{  

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.haima.crm.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CRM RESTful APIs")
                .description("CRM系统投诉单管理、人车查询相关接口")
                .termsOfServiceUrl("http://crm.tongter.com:8088/#/login")
                .contact("豆金贤")
                .version("1.0")
                .build();
    }

}
