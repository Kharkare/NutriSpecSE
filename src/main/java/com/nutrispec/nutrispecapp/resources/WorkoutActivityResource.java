package com.nutrispec.nutrispecapp.resources;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;

import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.FoodActivity;
import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.WorkoutActivity;
import com.nutrispec.nutrispecapp.services.FoodActivityService;
import com.nutrispec.nutrispecapp.services.WorkoutActivityService;

@Path("/clients")
public class WorkoutActivityResource implements ResourceResponse {
	
	@Context
    Configuration config;
	
	WorkoutActivityService workService;
	
	@Path("/addWorkoutActivity")
	public JsonResponse<WorkoutActivity> addWorkoutActivity(WorkoutActivity workoutActivity){
		workService = new WorkoutActivityService((Connection) config.getProperty("conn"));
		
		return sendResponse(workoutActivity, "Workout Activity added successfuly");
	}
	
	@Path("/getAllWorkoutActivity")
	public JsonResponse<List<WorkoutActivity>> getAllWorkoutActivities(Client client){
		workService = new WorkoutActivityService((Connection) config.getProperty("conn"));
		List<WorkoutActivity> list = workService.getAllWorkoutActivities(client);
		return sendResponse(list, "List of All Workout Activities");
	}
	
}
