package com.tutorial7.fetchScheduleFromAWSRDS;

import com.tutorial7.fetchScheduleFromAWSRDS.controller.retrieveScheduleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses ={retrieveScheduleController.class})
public class FetchScheduleFromAwsrdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchScheduleFromAwsrdsApplication.class, args);
	}

}
