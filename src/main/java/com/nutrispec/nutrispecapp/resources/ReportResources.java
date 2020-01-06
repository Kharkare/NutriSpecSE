package com.nutrispec.nutrispecapp.resources;

import java.sql.Connection;

import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.Report;
import com.nutrispec.nutrispecapp.services.FoodActivityService;
import com.nutrispec.nutrispecapp.services.WorkoutActivityService;

public class ReportResources implements ResourceResponse {
	
	Connection conn;
	
	FoodActivityService food_service;
	WorkoutActivityService work_service;
	
	public ReportResources(Connection conn) {
		this.conn = conn;
	}
	
	public JsonResponse<Report> getReport(Report report) {
		
		
		return sendResponse(report, "Report generated successfuly");
	}

}
