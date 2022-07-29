package it.aizoon.batch.jobs.fo_bo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Configuration;

import it.aizoon.batch.jobs.fo_bo.model.Request;

@EnableBatchProcessing
@Configuration
public class FoToBoMigrationJob extends SimpleJob {
    
    public FoToBoMigrationJob(JobRepository jobRepository, StepBuilderFactory stepBuilderFactory, FoReader reader, BoWriter writer) {
        super("foToBoMigrationJob");

        setJobRepository(jobRepository);
        setJobParametersIncrementer( new RunIdIncrementer() );
        addStep(
            stepBuilderFactory.get("step1")
                .<Request, Request> chunk(1)
                .reader(reader)
                .writer(writer)
                .build()
        );
        
    }
    
}
