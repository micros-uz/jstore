package uz.micros.estore.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.host}")
    private String hostName;
    @Value("${jdbc.port}")
    private String prt;
    @Value("${jdbc.dbName}")
    private String dbName;
    @Value("${jdbc.userName}")
    private String userName;
    @Value("${jdbc.password}")
    private String pwd;


    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        String username = System.getenv("OPENSHIFT_POSTGRESQL_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_POSTGRESQL_DB_PASSWORD");
        String host = System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");
        String databaseName = System.getenv("OPENSHIFT_APP_NAME");

        if (host == null) {
            host = hostName;
            port = prt;
            username = userName;
            password = pwd;
            databaseName = dbName;
        }

        String url = "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        dataSource.setValidationQuery("SELECT version()");

        return dataSource;
    }
}
