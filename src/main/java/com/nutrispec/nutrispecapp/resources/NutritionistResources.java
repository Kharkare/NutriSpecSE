package com.nutrispec.nutrispecapp.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.Nutritionist;
import com.nutrispec.nutrispecapp.services.NutritionistService;

@Path("/nutritionist")
public class NutritionistResources implements ResourceResponse {
	
	@Context
    Configuration config;
	
	NutritionistService service;
	
	@Path("/register")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<Nutritionist> registerNutritionist(Nutritionist nutritionist) {
		try {
			service.registerClient(nutritionist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(nutritionist, "Nutritionist registered successfuly");
	}
	
	@Path("/unroll")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<Client> unrollClient(Nutritionist nutritionist, Client client){
		
		service.unroll(nutritionist,client);
		return sendResponse(client, "Client unrolled sccessfuly");
	} 

}
