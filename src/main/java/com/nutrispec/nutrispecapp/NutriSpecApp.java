package com.nutrispec.nutrispecapp;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/webapi")
public class NutriSpecApp extends ResourceConfig {
	
	@Context
	ServletContext context;
	
	public NutriSpecApp() throws SQLException, ClassNotFoundException {
		property("conn", ApplicationConfig.getInstance().getConnection());
	}
}
