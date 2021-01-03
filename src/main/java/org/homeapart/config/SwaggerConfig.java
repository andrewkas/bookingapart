package org.homeapart.config;

import org.homeapart.security.util.CustomHeaders;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwaggerConfig {


    private ApiInfo apiInfo() {
        return new ApiInfo("BOOKING application",
                "Some custom description of API.",
                "1.0",
                "Terms of service",
                new Contact("Andrew Kashpar", "", "c_a_s@list.ru"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
            //    .paths(PathSelectors.ant("/user/**"))
            //    .paths(PathSelectors.ant("/landlord/**"))
            //    .paths(PathSelectors.ant("/apart/**"))
            //    .paths(PathSelectors.ant("/booking/**"))

                .apis(RequestHandlerSelectors.basePackage("org.homeapart.controller"))
                .paths(PathSelectors.any())
                .build();





    }


    private ApiKey apiKey() {
        return new ApiKey("JWT", CustomHeaders.AUTH_HEADER, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

}

