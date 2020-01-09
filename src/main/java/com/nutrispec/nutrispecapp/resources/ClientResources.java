package com.nutrispec.nutrispecapp.resources;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nutrispec.nutrispecapp.models.Association;
import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.Nutritionist;
import com.nutrispec.nutrispecapp.models.NutritionistRatings;
import com.nutrispec.nutrispecapp.services.ClientService;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResources implements ResourceResponse {
	
	@Context
    Configuration config;
	
	ClientService clientService;
	
	
	@Path("/register")
	@POST
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
	public JsonResponse<NutritionistRatings> addNutritionistRatings(NutritionistRatings ratings){
		try {
			clientService = new ClientService((Connection)config.getProperty("conn"));
			clientService.addRatings(ratings);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(ratings, "Ratings added successfully");
	}
	
	@Path("/unroll")
	@POST
	public JsonResponse<Association> unrollClient(Association associate){
		
		try {
			clientService = new ClientService((Connection)config.getProperty("conn"));
			clientService.unroll(associate);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(associate, "Client unrolled successfuly");
	}
	
	@Path("/enroll")
	@POST
	public JsonResponse<Association> enrollClient(Association association){
		clientService = new ClientService((Connection)config.getProperty("conn"));
		try {
			clientService.enroll(association);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sendResponse(association, "Client Enrolled successfuly");
	}
	

}
