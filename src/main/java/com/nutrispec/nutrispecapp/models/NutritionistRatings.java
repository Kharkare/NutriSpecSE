package com.nutrispec.nutrispecapp.models;

public class NutritionistRatings {
	
	private String id;
	private String clientId;
	private String nutritionistId;
	private String ratingsInNumbers;
	private String ratingsText;
	private Client client;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String customerId) {
		this.clientId = customerId;
	}
	public String getNutritionistId() {
		return nutritionistId;
	}
	public void setNutritionistId(String nutritionistId) {
		this.nutritionistId = nutritionistId;
	}
	public String getRatingsInNumbers() {
		return ratingsInNumbers;
	}
	public void setRatingsInNumbers(String ratingsInNumbers) {
		this.ratingsInNumbers = ratingsInNumbers;
	}
	public String getRatingsText() {
		return ratingsText;
	}
	public void setRatingsText(String ratingsText) {
		this.ratingsText = ratingsText;
	}
	
	
}
