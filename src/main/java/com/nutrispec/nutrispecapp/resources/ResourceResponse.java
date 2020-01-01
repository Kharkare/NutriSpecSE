package com.nutrispec.nutrispecapp.resources;

import com.nutrispec.nutrispecapp.models.JsonResponse;

public interface ResourceResponse {
	
	default <T> JsonResponse<T> sendResponse(T model, String message) {
		JsonResponse<T> resp = new JsonResponse<T>(model);
		resp.setMessage(message);
		resp.setResult("1");
		resp.setSuccess(true);
		return resp;
	}

}
