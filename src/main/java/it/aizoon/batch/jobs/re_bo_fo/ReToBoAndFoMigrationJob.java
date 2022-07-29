package it.aizoon.batch.jobs.re_bo_fo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Configuration;

import it.aizoon.batch.jobs.re_bo_fo.model.Request;
import it.aizoon.batch.jobs.re_bo_fo.reader.ReRequestReader;
import it.aizoon.batch.jobs.re_bo_fo.writer.BoRequestWriter;
import it.aizoon.batch.jobs.re_bo_fo.writer.FoRequestWriter;

@Configuration
@EnableBatchProcessing
public class ReToBoAndFoMigrationJob extends SimpleJob {
    public ReToBoAndFoMigrationJob(JobRepository jobRepository, StepBuilderFactory stepBuilderFactory,
    
        FoRequestWriter foRequestWriter,

        ReRequestReader reRequestReader,
        BoRequestWriter boRequestWriter
    ) {
        super("reToBoAndFoMigrationJob");

        setJobRepository(jobRepository);
        setJobParametersIncrementer( new RunIdIncrementer() );

        addStep(
                stepBuilderFactory.get("step1")
                        .<Request, Request> chunk(1)
                        .reader(reRequestReader)
                        .writer(foRequestWriter)
                        .build()
        );

        addStep(
                stepBuilderFactory.get("step2")
                        .<Request, Request> chunk(1)
                        .reader(reRequestReader)
                        .writer(boRequestWriter)
                        .build()
        );
    }

}
