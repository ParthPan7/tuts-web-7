package com.tutorial7.fetchScheduleFromAWSRDS.dao;

import com.tutorial7.fetchScheduleFromAWSRDS.DataBaseConnection.DataBaseConnectivity;
import com.tutorial7.fetchScheduleFromAWSRDS.services.EmployeeSchedule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RetrieveSchedule {
    String query;
    Statement statement;
    private static Logger logger = LogManager.getLogger(RetrieveSchedule.class);

    public ArrayList<EmployeeSchedule> returnSchedule() throws SQLException {
        ArrayList<EmployeeSchedule> schedules  = new ArrayList<>();
        ResultSet result;


        query = "select * from Schedule_DB";

        try {
            statement = DataBaseConnectivity.obtainDatabaseConnection().createStatement();
            //statement = DataBaseConnectivity.obtainDatabaseConnection().prepareStatement(que;

            result = statement.executeQuery(query);

            while (result.next()) {

                EmployeeSchedule e = new EmployeeSchedule();
                System.out.println(result.getString("Name"));
                e.setName(result.getString("Name"));
                e.setMon(result.getString("Monday"));
                e.setTues(result.getString("Tuesday"));
                e.setWed(result.getString("Wednesday"));
                e.setThrus(result.getString("Thursday"));
                e.setFri(result.getString("Friday"));
                e.setSat(result.getString("Saturday"));
                e.setSun(result.getString("Sunday"));
                schedules.add(e);
            }
        }

        catch (SQLException e) {
            logger.error(e);
        }

        return schedules;

    }


}
