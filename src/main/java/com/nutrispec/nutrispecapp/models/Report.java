package com.nutrispec.nutrispecapp.models;

import java.util.List;

public class Report {
	
	private String nutritionist_id;
	private String client_id;
	private List<FoodActivity> food_activity;
	private List<WorkoutActivity> workout_activity;
	private String fromDate;
	private String toDate;
	private String time;
	
	public List<WorkoutActivity> getWorkout_activity() {
		return workout_activity;
	}
	public void setWorkout_activity(List<WorkoutActivity> workout_activity) {
		this.workout_activity = workout_activity;
	}
	
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String date) {
		this.fromDate = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getNutritionist_id() {
		return nutritionist_id;
	}
	public void setNutritionist_id(String nutritionist_id) {
		this.nutritionist_id = nutritionist_id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public List<FoodActivity> getFood_activity() {
		return food_activity;
	}
	public void setFood_activity(List<FoodActivity> food_activity) {
		this.food_activity = food_activity;
	}

}
