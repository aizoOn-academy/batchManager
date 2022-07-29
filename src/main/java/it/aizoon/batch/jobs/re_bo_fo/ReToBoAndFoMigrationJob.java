package it.aizoon.batch.jobs.re_bo_fo;

import it.aizoon.batch.jobs.fo_bo.model.Request;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;

public class ReToBoAndFoMigrationJob extends SimpleJob {
    public ReToBoAndFoMigrationJob(JobRepository jobRepository, StepBuilderFactory stepBuilderFactory, ReReader reader, BoWriter writer1, FoWriter writer2) {
        super("reToBoAndFoMigrationJob");

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
