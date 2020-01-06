package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.Report;
import com.nutrispec.nutrispecapp.models.WorkoutActivity;

public class WorkoutActivityService {
	
	private Connection conn;
	
	
	public WorkoutActivityService(Connection conn) {
		this.conn = conn;
	}
	
	public WorkoutActivity addWorkoutActivity(WorkoutActivity workoutActivity) {
		
		return workoutActivity;
	}
	
	public List<WorkoutActivity> getAllWorkoutActivities(Client client){
		List<WorkoutActivity> allWorkoutActivities = new ArrayList<WorkoutActivity>();
		
		return allWorkoutActivities;
	}
	
	public Report getAllWorkoutActivitiesAsPerDate(Report report){
		
		return report;
	}
	
	
}
