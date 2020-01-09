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

import com.nutrispec.nutrispecapp.models.Association;
import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.Nutritionist;
import com.nutrispec.nutrispecapp.services.ClientService;
import com.nutrispec.nutrispecapp.services.NutritionistService;

@Path("/nutritionist")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NutritionistResources implements ResourceResponse {
	
	@Context
    Configuration config;
	
	NutritionistService service;
	
	@Path("/register")
	@POST
	public JsonResponse<Nutritionist> registerNutritionist(Nutritionist nutritionist) {
		try {
			service = new NutritionistService((Connection) config.getProperty("conn"));
			service.registerClient(nutritionist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(nutritionist, "Nutritionist registered successfuly");
	}
	
	@Path("/unroll")
	@POST
	public JsonResponse<Association> unrollClient(Association associate){
		service = new NutritionistService((Connection) config.getProperty("conn"));
		try {
			service.unroll(associate);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(associate, "Client unrolled sccessfuly");
	}
	
	@Path("/getclients")
	@POST
	public JsonResponse<List<Client>> getClients(Nutritionist nutritionist){
		service = new NutritionistService((Connection) config.getProperty("conn"));
		List<Client> client_list = null;
		try {
			client_list = service.getClients(nutritionist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(client_list, "List of all clients associated");
		
	}

}
