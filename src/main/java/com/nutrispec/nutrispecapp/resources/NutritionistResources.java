package com.nutrispec.nutrispecapp.resources;

import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;

import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.Nutritionist;
import com.nutrispec.nutrispecapp.services.NutritionistService;

@Path("/nutritionist")
public class NutritionistResources implements ResourceResponse {
	
	@Context
    Configuration config;
	
	NutritionistService service;
	
	@POST
	@Path("/register")
	public JsonResponse<Nutritionist> registerNutritionist(Nutritionist nutritionist) {
		try {
			service.registerClient(nutritionist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(nutritionist, "Nutritionist registered successfuly");
	}

}
