package com.nutrispec.nutrispecapp.resources;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.Nutritionist;
import com.nutrispec.nutrispecapp.models.NutritionistRatings;
import com.nutrispec.nutrispecapp.services.ClientService;
import com.nutrispec.nutrispecapp.services.NutritonistRatingsService;

@Path("/clients")
public class ClientResources implements ResourceResponse {
	
	@Context
    Configuration config;
	
	ClientService clientService;
	NutritonistRatingsService nutritionistRatingsService;
	
	
	@Path("/register")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<Client> registerClient(Client client){
		System.out.println("Name:"+client.getName());
		try {
			clientService = new ClientService((Connection)config.getProperty("conn"));
			clientService.registerClient(client);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(client,"Client created succesfuly");
	}
	
	@Path("/addRatings")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<NutritionistRatings> addNutritionistRatings(NutritionistRatings ratings){
		try {
			nutritionistRatingsService = new NutritonistRatingsService((Connection)config.getProperty("conn"));
			nutritionistRatingsService.addRatings(ratings);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(ratings, "Ratings added successfully");
	}
	
	@Path("/unroll")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<Nutritionist> unrollClient(Nutritionist nutritionist, Client client){
		
		clientService.unroll(nutritionist,client);
		return sendResponse(nutritionist, "Client unrolled sccessfuly");
	} 

}
