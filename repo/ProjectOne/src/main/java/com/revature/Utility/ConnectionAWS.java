package com.revature.Utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.catalina.loader.WebappLoader;


public class ConnectionAWS {
	
	private static Connection con;
	
	public static Connection getConnectionFromFile() throws SQLException, IOException
	{
		// loading connection.properties file in order to read properties
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("Connection.properties"));
		
		// using ZK specific WebApps util
		//ServletContext servletContext = WebappLoader.getCurrent().getServletContext();
		// Servlet API
		//InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/aws.properties");
		//Properties myProps = new Properties();
		//myProps.load(inputStream);
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		try{ Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace(); }

		if(con == null || con.isClosed()) {
		con = DriverManager.getConnection(url, username, password);
		}
		
		return con;
	}
	
}
