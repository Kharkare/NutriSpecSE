package com.nutrispec.nutrispecapp.models;

public class FoodActivity {
	
	private String id;
	private String activity_date;
	private String activity_time;
	private String quantity;
	private Client client;
	private FoodDictionary food_dictionary;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActivity_date() {
		return activity_date;
	}
	public void setActivity_date(String activity_date) {
		this.activity_date = activity_date;
	}
	public String getActivity_time() {
		return activity_time;
	}
	public void setActivity_time(String activity_time) {
		this.activity_time = activity_time;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public FoodDictionary getFood_dictionary() {
		return food_dictionary;
	}
	public void setFood_dictionary(FoodDictionary food_dictionary) {
		this.food_dictionary = food_dictionary;
	}

}
