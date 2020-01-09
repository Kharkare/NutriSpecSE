package com.nutrispec.nutrispecapp.models;

public class Association {
	
	private Client client;
	private Nutritionist nutritionist;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Nutritionist getNutritionist() {
		return nutritionist;
	}
	public void setNutritionist(Nutritionist nutritionist) {
		this.nutritionist = nutritionist;
	}

}
