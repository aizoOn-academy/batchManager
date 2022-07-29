package it.aizoon.batch.configurations;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfigurations {

    @Bean @Primary
    public DataSource batchDB() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/batch?createDatabaseIfNotExist=true");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }

    @Bean
    public DataSource frontOfficeDB() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://10.244.244.146:3310/frontoffice");
        dataSourceBuilder.username("frontoffice");
        dataSourceBuilder.password("frontoffice2022");
        return dataSourceBuilder.build();
    }

    @Bean
    public DataSource backOfficeDB() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://10.244.244.146:3311/backoffice");
        dataSourceBuilder.username("backoffice");
        dataSourceBuilder.password("backoffice123");
        return dataSourceBuilder.build();
    }

    @Bean
    public DataSource rendicontazioneDB() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://10.244.244.146:3312/rendicontazione");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }

}
