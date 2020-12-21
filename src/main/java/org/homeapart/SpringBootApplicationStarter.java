package org.homeapart;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.homeapart.config.ApplicationBean;
import org.homeapart.config.PersistenceContextBeansConfiguration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication (scanBasePackages = "org.homeapart")
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import ({ApplicationBean.class,PersistenceContextBeansConfiguration.class})
public class SpringBootApplicationStarter implements ApplicationRunner{
    private static final Logger LOGGER = LogManager.getLogger(SpringBootApplicationStarter.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationStarter.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LOGGER.info("start logger");
    }
}
