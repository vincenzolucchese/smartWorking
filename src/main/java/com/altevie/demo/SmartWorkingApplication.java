package com.altevie.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SmartWorkingApplication {

	private static final Logger logger = LoggerFactory.getLogger(SmartWorkingApplication.class);
		
	public static void main(String[] args) {
		SpringApplication.run(SmartWorkingApplication.class, args);
		logger.info("Start procedure."); 
		StepManager stepper = new StepManager();
		stepper.doSteps();
		logger.info("End procedure."); 
	}	


}
