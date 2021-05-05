package com.revature.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	private static Connection connection;
	
	public static Connection getHardCodedConnection() throws SQLException
	{

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "002Guitars#";

		if(connection == null || connection.isClosed()) {
		connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
}