package com.springbatch.demo.runner;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.springbatch.demo.utils.Constants;

import java.util.Date;

//this class is to trigger our job

@Component
public class JobRunner {

	private static final Logger logger = LoggerFactory.getLogger(JobRunner.class);

	private JobLauncher simpleJobLauncher;
	private Job demo1;

	@Autowired
	public JobRunner(Job demo1, JobLauncher jobLauncher) {
		this.simpleJobLauncher = jobLauncher;
		this.demo1 = demo1;
	}

	//we have not provided any file name in the reader part and here we are providing the filename in the run time
	@Async //
	public void runBatchJob() {
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addString(Constants.FILE_NAME_CONTEXT_KEY, "employees.csv");
		jobParametersBuilder.addDate("date", new Date(), true);
		runJob(demo1, jobParametersBuilder.toJobParameters());
	}

	public void runJob(Job job, JobParameters parameters) {
		try {
			JobExecution jobExecution = simpleJobLauncher.run(job, parameters);
		} catch (JobExecutionAlreadyRunningException e) {
			logger.info("Job with fileName={} is already running.",
					parameters.getParameters().get(Constants.FILE_NAME_CONTEXT_KEY));
		} catch (JobRestartException e) {
			logger.info("Job with fileName={} was not restarted.",
					parameters.getParameters().get(Constants.FILE_NAME_CONTEXT_KEY));
		} catch (JobInstanceAlreadyCompleteException e) {
			logger.info("Job with fileName={} already completed.",
					parameters.getParameters().get(Constants.FILE_NAME_CONTEXT_KEY));
		} catch (JobParametersInvalidException e) {
			logger.info("Invalid job parameters.", parameters.getParameters().get(Constants.FILE_NAME_CONTEXT_KEY));
		}
	}
}
