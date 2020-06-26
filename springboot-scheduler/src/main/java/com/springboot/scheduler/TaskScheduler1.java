package com.springboot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduler1 {

	@Scheduled(fixedRate = 5000, initialDelay = 10000) //runs every 5 seconds with 10 seconds delay in the start
	//@Scheduled(fixedDelay = 10000) //wait (delay) for 10 seconds for a 2nd run
	//@Scheduled(cron="* * * * * *") // the starts indicates -> (secs mins hours days months years)
	//@Scheduled(cron="*/10 * * * * *") //runs every 10 seconds
	
	public void taskScheduling() {

		System.out.println("Welcome to Task scheduling " + new java.util.Date());
	}

}
