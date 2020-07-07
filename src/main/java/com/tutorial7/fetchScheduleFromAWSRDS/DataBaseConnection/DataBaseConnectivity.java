package com.tutorial7.fetchScheduleFromAWSRDS.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DataBaseConnectivity {
	static Connection databaseConnection;
	private static Map<String, String> dataBaseCrediatialList;
	private static DataBaseConnectivity obtainDataBaseConnectionInstance;
	private static Properties dataBaseprops;
	private static String dataBaseconfigFile;
	private static InputStream databasepropertyFile;
	private String server, port, database, username, password,driverName;
	private Logger logger = LogManager.getLogger(DataBaseConnectivity.class);

	private DataBaseConnectivity() {
		dataBaseCrediatialList = new HashMap<String, String>();
		dataBaseConfigurationLoaderModule();
	}

	public static DataBaseConnectivity instance() {
		if (null == obtainDataBaseConnectionInstance) {
			obtainDataBaseConnectionInstance = new DataBaseConnectivity();
		}
		return obtainDataBaseConnectionInstance;
	}

	private Map<String, String> dataBaseConfigurationLoaderModule() {

		try {
			dataBaseprops = new Properties();
			dataBaseconfigFile = "database.properties";
			databasepropertyFile = getClass().getClassLoader().getResourceAsStream(dataBaseconfigFile);
			dataBaseprops.load(databasepropertyFile);

			username = dataBaseprops.getProperty("username");
			dataBaseCrediatialList.put("username", username);

			password = dataBaseprops.getProperty("password");
			dataBaseCrediatialList.put("password", password);

			database = dataBaseprops.getProperty("database");
			dataBaseCrediatialList.put("database", database);

			server = dataBaseprops.getProperty("server");
			dataBaseCrediatialList.put("server", server);

			port = dataBaseprops.getProperty("port");
			dataBaseCrediatialList.put("port", port);
			
			driverName = dataBaseprops.getProperty("driverName");
			dataBaseCrediatialList.put("driverName",driverName );

		} catch (IOException e) {
			logger.error("Missing resource (Unable to load the configuration loader) ", e);
		}
		return dataBaseCrediatialList;

	}

	public static Connection obtainDatabaseConnection() {
		DataBaseConnectivity.instance();
		String user = dataBaseCrediatialList.get("username");
		String password = dataBaseCrediatialList.get("password");
		String database = dataBaseCrediatialList.get("database");
		String server = dataBaseCrediatialList.get("server");
		String port = dataBaseCrediatialList.get("port");
		String driverName =  dataBaseCrediatialList.get("driverName");
		
		String databaseConnectionURL = "jdbc:mysql://" + server + ":" + port + "/" + database;
		System.out.print(databaseConnectionURL);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			databaseConnection = DriverManager.getConnection(databaseConnectionURL, user, password);

		} catch (Exception e) {

			System.out.println("Error occured while connecting to remote database : " + e);
		}
		return databaseConnection;
	}

	public static boolean terminateConnection() {
		try {

			if (databaseConnection.isClosed() == false) {

				databaseConnection.close();
			}

		} catch (SQLException e) {
			System.out.println("Error terminating connection with server " + e);
		}

		return true;

	}
	
}
