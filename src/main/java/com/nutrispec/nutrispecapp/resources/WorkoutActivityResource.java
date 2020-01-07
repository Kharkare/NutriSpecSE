package com.nutrispec.nutrispecapp.resources;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.FoodActivity;
import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.WorkoutActivity;
import com.nutrispec.nutrispecapp.services.FoodActivityService;
import com.nutrispec.nutrispecapp.services.WorkoutActivityService;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkoutActivityResource implements ResourceResponse {
	
	@Context
    Configuration config;
	
	WorkoutActivityService workService;
	
	@Path("/addWorkoutActivity")
	@POST
	public JsonResponse<WorkoutActivity> addWorkoutActivity(WorkoutActivity workoutActivity){
		workService = new WorkoutActivityService((Connection) config.getProperty("conn"));
		try {
			workService.addWorkoutActivity(workoutActivity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(workoutActivity, "Workout Activity added successfuly");
	}
	
	@Path("/getAllWorkoutActivity")
	@POST
	public JsonResponse<List<WorkoutActivity>> getAllWorkoutActivities(Client client){
		workService = new WorkoutActivityService((Connection) config.getProperty("conn"));
		List<WorkoutActivity> list = null;
		try {
			list = workService.getAllWorkoutActivities(client);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(list, "List of All Workout Activities");
	}
	
}
