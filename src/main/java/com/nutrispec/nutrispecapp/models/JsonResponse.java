package com.nutrispec.nutrispecapp.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResponse<T> {
	
	private String result;
	private String message;
	private boolean success;
	private T model;
	
	public JsonResponse(T model) {
		this.model = model;
	}

	
	public void setResult(String result) {
		this.result = result;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	public String getResult() {
		return result;
	}


	public String getMessage() {
		return message;
	}


	public boolean isSuccess() {
		return success;
	}


	public T getModel() {
		return model;
	}

}
