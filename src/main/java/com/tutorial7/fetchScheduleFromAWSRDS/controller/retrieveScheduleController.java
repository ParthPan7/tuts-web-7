package com.tutorial7.fetchScheduleFromAWSRDS.controller;


import com.tutorial7.fetchScheduleFromAWSRDS.services.EmployeeSchedule;
import com.tutorial7.fetchScheduleFromAWSRDS.services.retrieveScheduleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class retrieveScheduleController {
	@RequestMapping("/")
	public ArrayList<EmployeeSchedule> retrieveSchdeule() throws SQLException {
		return new retrieveScheduleService().returnSchedule();
	}
	
}
