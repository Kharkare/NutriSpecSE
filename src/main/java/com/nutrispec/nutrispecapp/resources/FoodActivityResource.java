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
public class FoodActivityResource implements ResourceResponse {
	
	@Context
    Configuration config;
	
	FoodActivityService foodService;
	
	@Path("/addFoodActivity")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<FoodActivity> addFoodActivity(FoodActivity foodActivity){
		foodService = new FoodActivityService((Connection) config.getProperty("conn"));
		try {
			foodService.addFoodActivity(foodActivity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(foodActivity, "Food Activity added successfuly");
	}
	
	@Path("/getAllFoodActivity")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<List<FoodActivity>> getAllFoodActivities(Client client){
		foodService = new FoodActivityService((Connection) config.getProperty("conn"));
		List<FoodActivity> list = null;
		try {
			list = foodService.getAllFoodActivities(client);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(list, "List of All Food Activities");
	}
	
	

}
