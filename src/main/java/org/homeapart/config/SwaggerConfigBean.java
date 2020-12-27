package org.homeapart.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

public class SwaggerConfigBean {
    @Bean
    public Docket get() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.paths(PathSelectors.ant("/user/**"))
                .apis(RequestHandlerSelectors.basePackage("org.homeapart.controller"))
                .build().apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfo("Booking API",
                "Booking aparts",
                "1.00",
                "http://",
                new Contact("Andrew", "http://", "c_a_s@list.ru"),
                "my own licence",
                "http://",
                Collections.emptyList()
        );
    }
}
