package org.homeapart.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

public class PersistenceContextBeansConfiguration {
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {

        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        factoryBean.setPackagesToScan("org.homeapart");
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(getAdditionalProperties());
        factoryBean.afterPropertiesSet();

        SessionFactory sf = factoryBean.getObject();
        System.out.println("## getSessionFactory: " + sf);
        return sf;
    }

    private Properties getAdditionalProperties() {
        Properties properties = new Properties();


        properties.put("hibernate.format_sql","true");
        properties.put("hibernate.use_sql_comments","true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.connection.characterEncoding", "utf8mb4");
        properties.put("hibernate.connection.CharSet", "utf8mb4");
        properties.put("hibernate.connection.useUnicode", "true");
        properties.put("current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
        properties.put("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");
      //  properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
      //  properties.put("hibernate.cache.use_second_level_cache", "true");
      //  properties.put("hibernate.cache.ehcache.missing_cache_strategy", "create");
      //  properties.put("hibernate.cache.use_query_cache", "true");
        return properties;
    }
}

