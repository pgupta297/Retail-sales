package com.training.utils;

import javax.sql.DataSource;

import java.sql.*;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.*;
public class ConnectionUtils {
	
	private static String[] getProsAsArray() throws IOException{
		
		String fileName="resources/DbConnection.properties";
		InputStream stream = ConnectionUtils.class.getClassLoader().getResourceAsStream(fileName);
		
		
		Properties pros= new Properties();
		pros.load(stream);
		String url = pros.getProperty("database.url");
		String userName = pros.getProperty("database.userName");
		String passWord = pros.getProperty("database.passWord");
		
		return new String[] {url, userName, passWord};
	}
	
	
	public static Connection getConnectionFromPool() {
		Connection connection=null;
		try {
			HikariConfig config = new HikariConfig();
			String[] values = getProsAsArray();
			config.setJdbcUrl(values[0]);
			config.setUsername(values[1]);
			config.setPassword(values[2]);
			config.addDataSourceProperty("maximumPoolSize", 25);
			
			DataSource dataSource = new HikariDataSource(config);
			
			connection= dataSource.getConnection();
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
}
