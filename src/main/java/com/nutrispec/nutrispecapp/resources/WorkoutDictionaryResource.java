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

import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.WorkoutDictionary;
import com.nutrispec.nutrispecapp.services.WorkoutDictionaryService;

@Path("/main")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkoutDictionaryResource implements ResourceResponse {
	
	@Context
    Configuration config;
	
	WorkoutDictionaryService service;
	
	@Path("/addWorkoutDictionary")
	@POST
	public JsonResponse<WorkoutDictionary> addWorkoutDictionary(WorkoutDictionary workout_dictionary) {
		
		service = new WorkoutDictionaryService((Connection) config.getProperty("conn"));
		workout_dictionary = service.addWorkoutDictionary(workout_dictionary);
		return sendResponse(workout_dictionary, "Workout Dictionary added successfuly");
	}
	
	
	@Path("/deleteWorkoutDictionary")
	@POST
	public JsonResponse<WorkoutDictionary> deleteWorkoutDictionary(WorkoutDictionary work_dict){
		service = new WorkoutDictionaryService((Connection) config.getProperty("conn"));
		work_dict = service.deleteWorkoutdictionary(work_dict);
		return sendResponse(work_dict, "Workout dictionary deleted");
	}
	
	@Path("/getWorkoutDictionary")
	public JsonResponse<List<WorkoutDictionary>> getWorkoutDictionary(){
		service = new WorkoutDictionaryService((Connection) config.getProperty("conn"));
		List<WorkoutDictionary> work_dict = service.getWorkoutdictionary();
		return sendResponse(work_dict, "Workout dictionary deleted");
	}

}
