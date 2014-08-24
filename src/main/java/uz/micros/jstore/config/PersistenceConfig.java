package uz.micros.jstore.config;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "uz.micros.jstore.repository")
public class PersistenceConfig {

    @Autowired
    private DataSource dataSource;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;
    //@Value("${hibernate.hbm2ddl.import_files}")
    //private String hibernateHbm2ddlImport;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setJpaVendorAdapter(jpaVendorAdapter());
        lef.setJpaProperties(hibernateProperties());
        lef.setPackagesToScan("uz.micros.jstore.entity");
        lef.setDataSource(dataSource);
        lef.afterPropertiesSet();

        return lef.getObject();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jva = new HibernateJpaVendorAdapter();
        jva.setShowSql(true);
        jva.setGenerateDdl(true);
        jva.setDatabase(Database.MYSQL);

        return jva;
    }

    Properties hibernateProperties() {
        final Properties res = new Properties();
        res.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        res.setProperty("hibernate.dialect", hibernateDialect);
        res.setProperty("hibernate.show_sql", hibernateShowSql);
        res.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        // import.sql is imported automatically
       // res.setProperty("hibernate.hbm2ddl.import_files", hibernateHbm2ddlImport);

        // hibernateProperties.setProperty("hibernate.format_sql", "true");
        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");

        return res;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());

        return transactionManager;
    }

    @Bean
    //@SpringRequestScoped
    public FullTextEntityManager fullTextEntityManager() {
        return Search.getFullTextEntityManager(entityManagerFactory().createEntityManager());
    }
}
