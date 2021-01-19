package org.homeapart.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

public class ApplicationBean {


        @Bean
        public JdbcTemplate jdbcTemplate(DataSource dataSource) {
            return new JdbcTemplate(dataSource);
        }

       @Bean
        public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
            return new NamedParameterJdbcTemplate(dataSource);
        }

        @Bean
        public CacheManager cacheManager() {
           CaffeineCacheManager cacheManager = new CaffeineCacheManager("apart","landlord");
           cacheManager.setCaffeine(cacheProperties());
           return cacheManager;
        }

        public Caffeine<Object, Object> cacheProperties() {
            return Caffeine.newBuilder()
                    .initialCapacity(10)
                    .maximumSize(50)
                    .expireAfterAccess(10, TimeUnit.MINUTES)
                    .weakKeys()
                    .recordStats();
        }


    }

