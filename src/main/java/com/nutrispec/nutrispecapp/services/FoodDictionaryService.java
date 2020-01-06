package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.nutrispec.nutrispecapp.models.FoodDictionary;

public class FoodDictionaryService {
	
	Connection conn;

	public FoodDictionaryService(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	public FoodDictionary addFoodDictionary(FoodDictionary food_dict) {
		// TODO Auto-generated method stub
		return food_dict;
	}

	public FoodDictionary deleteFoodDictionary(FoodDictionary food_dict) {
		// TODO Auto-generated method stub
		return food_dict;
	}

	public List<FoodDictionary> getFoodDictionary() {
		// TODO Auto-generated method stub
		List<FoodDictionary> list_food_dictionary = new ArrayList<FoodDictionary>();
		return list_food_dictionary;
	}

}
