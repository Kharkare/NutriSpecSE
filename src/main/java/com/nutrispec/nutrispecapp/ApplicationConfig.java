package com.nutrispec.nutrispecapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ApplicationConfig {
	
	private final Properties CONFIG = new Properties();
	private final String CONFIG_FILE_NAME = "config.properties";
	private static ApplicationConfig appConfig = null;
	
	private ApplicationConfig() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
		if (inputStream != null) {
			try {
				CONFIG.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception: " + e);
			} finally {
				inputStream.close();
			}
		} else {
			throw new FileNotFoundException("property file '" + CONFIG_FILE_NAME + "' not found in the classpath");
		}
	}
	
	public static ApplicationConfig getInstance() {
        if (appConfig == null) {  
	        synchronized(ApplicationConfig.class) {
	        	try {
					appConfig = new ApplicationConfig();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
        }
        return appConfig;
	}
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		StringBuilder builder = new StringBuilder();
		builder.append("jdbc:mysql://");
		builder.append(this.getDbHost());
		builder.append(":");
		builder.append(this.getDbPort());
		builder.append("/");
		builder.append(this.getDbName());

		System.out.println(builder.toString());
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(builder.toString(),this.getDbUname(),this.getDbPass());
	}
	
	private String getDbName() {
		return CONFIG.getProperty("db.dbName");
	}
	
	private String getDbPort() {
		return CONFIG.getProperty("db.port");
	}
	
	private String getDbUname() {
		return CONFIG.getProperty("db.uname");
	}
	
	private String getDbPass() {
		return CONFIG.getProperty("db.pass");
	}
	
	private String getDbHost() {
		return CONFIG.getProperty("db.host");
	} 

}
