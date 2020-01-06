package com.nutrispec.nutrispecapp.models;

public class WorkoutDictionary {
	private String id;
	private String workoutName;
	private String workoutDesc;
	private String calorie_per_unit;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWorkoutName() {
		return workoutName;
	}
	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}
	public String getWorkoutDesc() {
		return workoutDesc;
	}
	public void setWorkoutDesc(String workoutDesc) {
		this.workoutDesc = workoutDesc;
	}
	public String getCalorie_per_unit() {
		return calorie_per_unit;
	}
	public void setCalorie_per_unit(String calorie_per_unit) {
		this.calorie_per_unit = calorie_per_unit;
	}
}
