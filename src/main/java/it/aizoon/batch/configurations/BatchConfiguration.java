package it.aizoon.batch.configurations;

import javax.sql.DataSource;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfiguration {
    
    private final DataSource dataSource;
    private final PlatformTransactionManager transactionManager;

    public BatchConfiguration(@Qualifier("batchDB") DataSource dataSource, PlatformTransactionManager transactionManager) {
        this.dataSource = dataSource;
        this.transactionManager = transactionManager;
    }

    @Bean
    public JobRepository getJobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(transactionManager);
        factory.setIsolationLevelForCreate("ISOLATION_SERIALIZABLE");
        factory.setTablePrefix("BATCH_");
        factory.setMaxVarCharLength(1200);
        return factory.getObject();
    }

}
