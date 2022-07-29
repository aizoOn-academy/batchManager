package it.aizoon.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BatchApplication {

	private final static List<Job> jobs = new ArrayList<>();

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		ApplicationContext ctx = SpringApplication.run(BatchApplication.class, args);

		jobs.add(
			ctx.getBean("foToBoMigrationJob", Job.class)
		);

		jobs.add(
			ctx.getBean("boToReMigrationJob", Job.class)
		);

		jobs.add(
			ctx.getBean("reToBoAndFoMigrationJob", Job.class)
		);

		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
		for(Job job : jobs) {
			JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis()).toJobParameters();

			jobLauncher.run(job, jobParameters);
		}

	}

}
