package com.stockmarket.companyservice.application.config;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig 
{
	
    @Bean
    public Docket todoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("stockmarket-companyservice-api")
                .apiInfo(apiInfo())
                .select()
                .paths(postPaths())
                .build();
    }
    
    private Predicate<String> postPaths() {
        return (regex("/api/v1.0/market.*"));
    }
    
    private ApiInfo apiInfo() 
    {
        return new ApiInfoBuilder()
        		.title("Company Rest APIs")
                .description("API reference for Company Service")
                .contact(new Contact("Biswajit Mondal", "https://github.com/biswajit-hash", "biswa.mondal.it@gmail.com"))
                .version("1.0")
                .build();
    }
}
