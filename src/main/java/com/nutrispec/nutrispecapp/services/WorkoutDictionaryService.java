package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.nutrispec.nutrispecapp.models.WorkoutDictionary;

public class WorkoutDictionaryService {
	
	private Connection conn;
	
	public WorkoutDictionaryService(Connection conn) {
		this.conn = conn;
	}

	public WorkoutDictionary addWorkoutDictionary(WorkoutDictionary workout_dictionary) {
		// TODO Auto-generated method stub
		
		return workout_dictionary;
	}

	public WorkoutDictionary deleteWorkoutdictionary(WorkoutDictionary work_dict) {
		// TODO Auto-generated method stub
		return work_dict;
	}

	public List<WorkoutDictionary> getWorkoutdictionary() {
		// TODO Auto-generated method stub\
		List<WorkoutDictionary> list_workout = new ArrayList<WorkoutDictionary>();
		return list_workout;
	}

}
