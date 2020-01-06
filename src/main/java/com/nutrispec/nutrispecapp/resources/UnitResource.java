package com.nutrispec.nutrispecapp.resources;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.models.Unit;
import com.nutrispec.nutrispecapp.services.UnitService;

@Path("/main")
public class UnitResource implements ResourceResponse {
	
	@Context
    Configuration config;
	
	UnitService service;
	
	@Path("/addUnit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<Unit> addUnit(Unit unit){
		service = new UnitService((Connection)config.getProperty("conn"));
		service.addUnit(unit);
		return sendResponse(unit, "Unit added successfuly");
	}
	
	@Path("/deleteUnit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<Unit> deleteUnit(Unit unit){
		service = new UnitService((Connection)config.getProperty("conn"));
		service.deleteUnit(unit);
		return sendResponse(unit, "Unit deleted successfuly");
	}

}
