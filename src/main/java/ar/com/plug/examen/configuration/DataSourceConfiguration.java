package ar.com.plug.examen.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String className;
    @Value("${spring.datasource.jdbc-url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String secret;

    @Bean
    @Primary
    public DataSource customDataSource() {
        DriverManagerDataSource d = new DriverManagerDataSource();
        d.setDriverClassName(className);
        d.setUrl(url);
        d.setUsername(username);
        d.setPassword(secret);
        return d;
    }

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
}
