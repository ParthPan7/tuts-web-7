package com.tutorial7.fetchScheduleFromAWSRDS.dao;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class RetrieveScheduleTest {
    @Test
    void test() throws SQLException {
        RetrieveSchedule retrieveSchedule = new RetrieveSchedule();
        assertNotNull(retrieveSchedule.returnSchedule());
    }
}