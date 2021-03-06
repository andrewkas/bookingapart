package org.homeapart;




import org.homeapart.config.ApplicationBean;
import org.homeapart.config.PersistenceContextBeansConfiguration;
import org.homeapart.config.SwaggerConfig;
import org.homeapart.security.configuration.JwtTokenConfig;
import org.homeapart.security.configuration.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication (scanBasePackages = "org.homeapart")
@EnableSwagger2
@EnableCaching
@Import ({ApplicationBean.class
        ,PersistenceContextBeansConfiguration.class
        , SecurityConfig.class
        , JwtTokenConfig.class
        , SwaggerConfig.class})
public class SpringBootApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationStarter.class, args);
    }


}
