package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.FoodActivity;
import com.nutrispec.nutrispecapp.models.Report;

public class FoodActivityService {
	
	Connection conn;
	
	public FoodActivityService(Connection conn) {
		this.conn = conn;
	}
	
	public List<FoodActivity> getAllFoodActivities(Client client){
		List<FoodActivity> list_food_activity = new ArrayList<FoodActivity>();
		
		return list_food_activity;
	}
	
	public FoodActivity addFoodActivity(FoodActivity food_activity) {
		
		
		return food_activity;
	}
	
	public Report getAllFoodActivitiesAsPerDate(Report report) {
		
		
		return report;
	}

}
