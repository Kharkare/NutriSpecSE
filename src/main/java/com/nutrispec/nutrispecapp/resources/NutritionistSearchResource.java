package com.nutrispec.nutrispecapp.resources;

import javax.ws.rs.Path;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;

import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.NutritionistSearch;

@Path("/clients")
public class NutritionistSearchResource implements ResourceResponse {

	@Context
    Configuration config;
	
	@Path("/nutritionist")
	public JsonResponse<NutritionistSearch> getNutritionist(NutritionistSearch search){
		
		
		
		return sendResponse(search, "Nutritionist search successful");
	}
	
}
