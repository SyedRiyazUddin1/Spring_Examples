package com.springbatch.demo.config;

import org.springframework.batch.core.launch.JobLauncher;

import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

//class to create the job launcher and injecting it in JobRunner class
@Configuration
@EnableAsync
public class BaseConfig {

	public JobRepository jobRepository;

	@Autowired
	public BaseConfig(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}
//creating JobLauncher here which trigger our jobs
	@Bean
    public JobLauncher simpleJobLauncher() {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        return jobLauncher;
    }
}
