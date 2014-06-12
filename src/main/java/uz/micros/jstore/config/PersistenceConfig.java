package uz.micros.jstore.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(new String[]{"uz.micros.jstore.entity.blog"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    Properties hibernateProperties() {
        final Properties res = new Properties();
        res.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        res.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        res.setProperty("hibernate.show_sql", "true");
        // hibernateProperties.setProperty("hibernate.format_sql", "true");
        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");

        return res;
    }

    //@Bean
    private DataSource getDataSource() {
        final BasicDataSource res = new BasicDataSource();
        res.setDriverClassName("com.mysql.jdbc.Driver");
        res.setUrl("jdbc:mysql://localhost:3306/jstore?createDatabaseIfNotExist=true");
        res.setUsername("root");
        res.setPassword("root");

        return res;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }
/*
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }*/
}
