package org.homeapart;




import org.homeapart.config.ApplicationBean;
import org.homeapart.config.PersistenceContextBeansConfiguration;

import org.homeapart.config.SwaggerConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication (scanBasePackages = "org.homeapart")
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import ({ApplicationBean.class,PersistenceContextBeansConfiguration.class, SwaggerConfigBean.class})
public class  SpringBootApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationStarter.class, args);
    }


}