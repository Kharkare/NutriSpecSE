package com.nutrispec.nutrispecapp.models;

import java.util.List;

public class Report {
	
	private String nutritionist_id;
	private String client_id;
	private List<FoodDictionary> food_dictionary;
	private List<FoodActivity> food_activity;
	private List<WorkoutDictionary> workout_dictionary;
	private List<WorkoutActivity> workout_activity;
	private String date;
	private String time;
	
	public List<WorkoutDictionary> getWorkout_dictionary() {
		return workout_dictionary;
	}
	public void setWorkout_dictionary(List<WorkoutDictionary> workout_dictionary) {
		this.workout_dictionary = workout_dictionary;
	}
	public List<WorkoutActivity> getWorkout_activity() {
		return workout_activity;
	}
	public void setWorkout_activity(List<WorkoutActivity> workout_activity) {
		this.workout_activity = workout_activity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public List<FoodDictionary> getFood_dictionary() {
		return food_dictionary;
	}
	public void setFood_dictionary(List<FoodDictionary> food_dictionary) {
		this.food_dictionary = food_dictionary;
	}
	public List<FoodActivity> getFood_activity() {
		return food_activity;
	}
	public void setFood_activity(List<FoodActivity> food_activity) {
		this.food_activity = food_activity;
	}

}
