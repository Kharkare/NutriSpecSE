package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.Report;
import com.nutrispec.nutrispecapp.models.WorkoutActivity;
import com.nutrispec.nutrispecapp.models.WorkoutDictionary;


public class WorkoutActivityService {
	
	private Connection conn;
	
	
	public WorkoutActivityService(Connection conn) {
		this.conn = conn;
	}
	
	public WorkoutActivity addWorkoutActivity(WorkoutActivity workoutActivity) throws SQLException {
		
		String query = "INSERT INTO tbl_client_workout_activity (id, client_id, workout_id, activity_date, activity_time, quantity) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, null);
		stmt.setInt(2, Integer.parseInt(workoutActivity.getClient().getId()));
		stmt.setInt(3, Integer.parseInt(workoutActivity.getWorkout().getId()));
		stmt.setDate(4, java.sql.Date.valueOf(workoutActivity.getActivity_date()));
		stmt.setString(5, workoutActivity.getActivity_time());
		stmt.setString(6, workoutActivity.getQuantity());
		
		stmt.execute();
		
		return workoutActivity;
	}
	
	public List<WorkoutActivity> getAllWorkoutActivities(Client client) throws SQLException{
		List<WorkoutActivity> allWorkoutActivities = new ArrayList<WorkoutActivity>();
		String query = "SELECT w.*,dict.id AS dict_id, dict.workout_name AS workout_name, dict.workout_desc AS workout_desc, dict.calorie_per_unit AS cal_per_unit FROM tbl_client_workout_activity w INNER JOIN tbl_workout_dictionary AS dict ON w.workout_id = dict.id WHERE w.client_id = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, Integer.parseInt(client.getId()));
		
		ResultSet result = stmt.executeQuery();
		
		while(result.next()) {
			WorkoutActivity workout_activity = new WorkoutActivity();
			workout_activity.setId(String.valueOf(result.getInt("id")));
			workout_activity.setClient(client);
			workout_activity.setActivity_date(result.getString("activity_date"));
			workout_activity.setActivity_time(result.getString("activity_time"));
			workout_activity.setQuantity(result.getString("quantity"));
			
			WorkoutDictionary dictionary = new WorkoutDictionary();
			dictionary.setCalorie_per_unit(result.getString("cal_per_unit"));
			dictionary.setId(String.valueOf(result.getInt("dict_id")));
			dictionary.setWorkoutDesc(result.getString("workout_desc"));
			dictionary.setWorkoutName(result.getString("workout_name"));
			workout_activity.setWorkout(dictionary);
			
			allWorkoutActivities.add(workout_activity);
		}
		
		return allWorkoutActivities;
	}
	
	public Report getAllWorkoutActivitiesAsPerDate(Report report){
		
		return report;
	}
	
	
}
