package com.igormascarenhas.amivulnerable.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket amivulnerableApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.igormascarenhas.amivulnerable"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());

    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
                "Am I vulnerable REST API",
                "REST API of Am I Vulnerable App.",
                "1.0",
                "Terms of Service",
                new Contact("Igor Mascarenhas", "https://www.linkedin.com/in/igor-mascarenhas/", "igorsmascarenhas@gmail.com"),
                "License - MIT", "https://opensource.org/licenses/MIT", new ArrayList<>()
        );

    }

}
