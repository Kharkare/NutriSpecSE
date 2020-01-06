package com.nutrispec.nutrispecapp.resources;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.nutrispec.nutrispecapp.models.Blog;
import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.JsonResponse;
import com.nutrispec.nutrispecapp.services.BlogService;

@Path("/nutritionist")
public class BlogResources implements ResourceResponse {
	
	@Context
	Configuration config;
	
	BlogService service;
	
	@Path("/addBlog")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse<Blog> addBlog(Blog blog) {
		service = new BlogService((Connection)config.getProperty("conn"));
		
		return sendResponse(blog,"Blog added succesfuly");
	}

}
