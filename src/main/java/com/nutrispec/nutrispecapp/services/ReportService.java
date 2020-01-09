package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.sql.SQLException;

import com.nutrispec.nutrispecapp.models.Report;

public class ReportService {
	
	Connection conn;
	
	public ReportService(Connection conn) {
		this.conn = conn;
	}
	
	public Report getReport(Report report) throws SQLException {
		FoodActivityService food_service = new FoodActivityService(this.conn);
		WorkoutActivityService work_service= new WorkoutActivityService(this.conn);
		report = food_service.getAllFoodActivitiesAsPerDate(report);
		report = work_service.getAllWorkoutActivitiesAsPerDate(report);
		return report;
	}

}
