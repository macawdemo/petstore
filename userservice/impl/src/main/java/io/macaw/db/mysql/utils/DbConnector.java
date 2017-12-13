package io.macaw.db.mysql.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnector {
	static Properties connectionProperties;

	private static DbConnector _instance;

	private static final String DB_DRIVER_CLASSNAME_KEY = "database.driver.classname";
	private static final String DB_URL_KEY = "database.url";
	private static final String DB_USERNAME_KEY = "database.username";
	private static final String DB_PASSWORD_KEY = "database.password";

	public static void initialise() {
		connectionProperties = new Properties();
		try {
			connectionProperties.load(
					new InputStreamReader(DbConnector.class.getClassLoader().getResourceAsStream("db.properties")));
		} catch (IOException e) {
			// TODO log or throw exception
		}
	}

	public static DbConnector getInstance() {
		if (_instance == null)
			_instance = new DbConnector();
		return _instance;
	}

	private DbConnector() {
	}

	public Connection getConnection() {
		try {
			Class.forName(connectionProperties.getProperty(DB_DRIVER_CLASSNAME_KEY));
			return DriverManager.getConnection(connectionProperties.getProperty(DB_URL_KEY),
					connectionProperties.getProperty(DB_USERNAME_KEY),"abcd123$");
		} catch (Exception e) {
			// TOOD log or throw exception
		}
		return null;
	}
	
	public void releaseConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
