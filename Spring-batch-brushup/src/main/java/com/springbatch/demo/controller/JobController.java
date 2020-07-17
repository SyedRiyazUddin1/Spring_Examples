package com.springbatch.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbatch.demo.runner.JobRunner;

/*

Note: when we run this application, only empty table will get created. 
When we hit the below URL, job will triggered and the data will be persisted in the DB
Url: http://localhost:8080/run/job
 */

@RestController
@RequestMapping("/run")
public class JobController {

	private JobRunner jobRunner;

	@Autowired
	public JobController(JobRunner jobRunner) {
		this.jobRunner = jobRunner;
	}

	@RequestMapping(value = "/job")
	public String runJob() {
		jobRunner.runBatchJob();
		return String.format("Job Demo1 submitted successfully.");

		/*
		 * we have used the annotation @Async in the JobRunner which means that the
		 * above method will return the message meanwhile the job will run in the
		 * background. This is useful when we have thousands of records.
		 */
	}
}
