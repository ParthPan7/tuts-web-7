package com.tutorial7.fetchScheduleFromAWSRDS.services;

import com.tutorial7.fetchScheduleFromAWSRDS.dao.RetrieveSchedule;

import java.sql.SQLException;
import java.util.ArrayList;

public class retrieveScheduleService {

    public ArrayList<EmployeeSchedule> returnSchedule() throws SQLException{
        return new RetrieveSchedule().returnSchedule();
    }
}
