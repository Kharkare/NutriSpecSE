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

import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.NutritionistSearch;
import com.nutrispec.nutrispecapp.services.NutritionistSearchService;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NutritionistSearchResource implements ResourceResponse {

	@Context
    Configuration config;
	
	NutritionistSearchService nutritionistService;
	
	@POST
	@Path("/nutritionist")
	public JsonResponse<NutritionistSearch> getNutritionist(NutritionistSearch search){
		
		nutritionistService = new NutritionistSearchService((Connection) config.getProperty("conn"));
		try {
			search = nutritionistService.searchNutritionist(search);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendResponse(search, "Nutritionist search successful");
	}
	
}
