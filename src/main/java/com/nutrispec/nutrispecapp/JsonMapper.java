package com.nutrispec.nutrispecapp;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface JsonMapper {
	
	ObjectMapper MAPPER = new ObjectMapper();
	
	public String getJson();
	
}
