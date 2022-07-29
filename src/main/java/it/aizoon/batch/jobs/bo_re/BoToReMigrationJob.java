package it.aizoon.batch.jobs.bo_re;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Configuration;

import it.aizoon.batch.jobs.bo_re.model.Operator;
import it.aizoon.batch.jobs.bo_re.model.Request;
import it.aizoon.batch.jobs.bo_re.readers.BoOperatorReader;
import it.aizoon.batch.jobs.bo_re.readers.BoRequestReader;
import it.aizoon.batch.jobs.bo_re.writers.ReOperatorWriter;
import it.aizoon.batch.jobs.bo_re.writers.ReRequestWriter;

@EnableBatchProcessing
@Configuration
public class BoToReMigrationJob extends SimpleJob {
    
    public BoToReMigrationJob(JobRepository jobRepository, StepBuilderFactory stepBuilderFactory,
        BoOperatorReader boOperatorReader,
        ReOperatorWriter reOperatorWriter,

        BoRequestReader boRequestReader,
        ReRequestWriter reRequestWriter
    ) {
        super("boToReMigrationJob");

        setJobRepository(jobRepository);
        setJobParametersIncrementer( new RunIdIncrementer() );
        addStep(
            stepBuilderFactory.get("step1")
                .<Operator, Operator> chunk(1)
                .reader(boOperatorReader)
                .writer(reOperatorWriter)
                .build()
        );
        addStep(
            stepBuilderFactory.get("step2")
                .<Request, Request> chunk(1)
                .reader(boRequestReader)
                .writer(reRequestWriter)
                .build()
        );
        
    }

}
