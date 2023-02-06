package com.shahed.shop.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${datasource.driverClassName}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.schema}")
    private String schema;

    @Value("${datasource.username}")
    private String username;


    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.minIdle}")
    private String minIdle;

    @Value("${datasource.maxPoolSize}")
    private String maxPoolSize;

    @Value("${datasource.connectionTimeoutSeconds}")
    private String connectionTimeoutSeconds;

    @Value("${datasource.idleTimeoutSeconds}")
    private String idleTimeoutSeconds;

    @Value("${datasource.maxLifetimeSeconds}")
    private String maxLifetimeSeconds;

    @Value("${datasource.validationTimeoutSeconds}")
    private String validationTimeoutSeconds;

    @Bean
    public DataSource getDataSource() {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setDriverClassName(driverClassName);
        config.setSchema(schema);
        config.setUsername(username);
        config.setPassword(password);
        config.setMinimumIdle(Integer.parseInt(minIdle)); //10
        config.setMaximumPoolSize(Integer.parseInt(maxPoolSize)); //10
        config.setConnectionTimeout(Integer.parseInt(connectionTimeoutSeconds) * 1000L);//30000
        config.setIdleTimeout(Integer.parseInt(idleTimeoutSeconds) * 1000L);//600000
        config.setMaxLifetime(Integer.parseInt(maxLifetimeSeconds) * 1000L);//1800000
        config.setValidationTimeout(Integer.parseInt(validationTimeoutSeconds) * 1000L);//5000
        return new HikariDataSource(config);
    }
}
