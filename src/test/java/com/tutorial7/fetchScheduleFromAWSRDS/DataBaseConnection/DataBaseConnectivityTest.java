package com.tutorial7.fetchScheduleFromAWSRDS.DataBaseConnection;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class DataBaseConnectivityTest {

	@Test
	void test() {

		DataBaseConnectivity dataBaseConnectivityInstance = DataBaseConnectivity.instance();
		Connection connection = dataBaseConnectivityInstance.obtainDatabaseConnection();
		System.out.print(connection);
		assertNotNull(connection);
	}

}
