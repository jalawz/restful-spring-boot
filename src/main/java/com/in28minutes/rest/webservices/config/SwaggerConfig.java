package com.in28minutes.rest.webservices.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final springfox.documentation.service.Contact DEFAULT_CONTACT =
            new Contact("Paulo Roberto Menezes", "http://www.paulo.com.br", "paulomenezes.web@gmail.com");
    public static final ApiInfo DEFAULT_API_INFO =
            new ApiInfo("Awesom Api title",
                    "Awesome Api Description",
                    "1.0", "",
                    DEFAULT_CONTACT,
                    "Apache 2.0",
                    "");
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Arrays.asList("application/json", "application/xml"));

    // Bean - Docket
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
