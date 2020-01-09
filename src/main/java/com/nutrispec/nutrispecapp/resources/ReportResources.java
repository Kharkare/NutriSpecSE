package com.nutrispec.nutrispecapp.resources;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.Report;
import com.nutrispec.nutrispecapp.services.FoodActivityService;
import com.nutrispec.nutrispecapp.services.ReportService;
import com.nutrispec.nutrispecapp.services.WorkoutActivityService;

@Path("/nutritionist")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReportResources implements ResourceResponse {
	
	@Context
    Configuration config;
	

	ReportService report_service;
	
	
	@Path("/report")
	public JsonResponse<Report> getReport(Report report) {
		
		report_service = new ReportService((Connection) config.getProperty("conn"));
		try {
			report = report_service.getReport(report);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(report, "Report generated successfuly");
	}

}
