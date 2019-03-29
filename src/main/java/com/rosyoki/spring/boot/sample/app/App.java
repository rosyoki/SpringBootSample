package com.rosyoki.spring.boot.sample.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    @Autowired
    public DataSource dataSource(DataSourceProperties dataSourceProperties) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                dataSourceProperties.getUrl(),
                dataSourceProperties.getUsername(),
                dataSourceProperties.getPassword()
        );

        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());

        return new TransactionAwareDataSourceProxy(dataSource);
    }
}
