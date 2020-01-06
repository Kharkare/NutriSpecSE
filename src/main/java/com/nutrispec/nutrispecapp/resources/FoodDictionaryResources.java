package com.nutrispec.nutrispecapp.resources;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nutrispec.nutrispecapp.models.FoodDictionary;
import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.services.FoodDictionaryService;

@Path("/main")
public class FoodDictionaryResources implements ResourceResponse {
	
	@Context
    Configuration config;
	
	FoodDictionaryService service;
	
	@Path("/addFoodDictionary")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<FoodDictionary> addFoodDictionary(FoodDictionary food_dict) {
		
		service = new FoodDictionaryService((Connection) config.getProperty("conn"));
		food_dict = service.addFoodDictionary(food_dict);
		return sendResponse(food_dict, "Food added to dictionary");
	}
	
	@Path("/deleteFoodDictionary")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<FoodDictionary> deleteFoodDictionary(FoodDictionary food_dict){
		
		service = new FoodDictionaryService((Connection) config.getProperty("conn"));
		
		food_dict = service.deleteFoodDictionary(food_dict);
		return sendResponse(food_dict, "Food Dictionary deleted");
	}
	
	@Path("/getFoodDictionary")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public JsonResponse<List<FoodDictionary>> getFoodDictionary(){
		service = new FoodDictionaryService((Connection) config.getProperty("conn"));
		List<FoodDictionary> list = service.getFoodDictionary();
		return sendResponse(list, "List of food dictionary");
	}
	
}
