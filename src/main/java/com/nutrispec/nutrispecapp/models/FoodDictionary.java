package com.nutrispec.nutrispecapp.models;

public class FoodDictionary {
	
	private String id;
	private String foodName;
	private String foodDesc;
	private String calorie_per_unit;
	private Unit unit;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodDesc() {
		return foodDesc;
	}
	public void setFoodDesc(String foodDesc) {
		this.foodDesc = foodDesc;
	}
	public String getCalorie_per_unit() {
		return calorie_per_unit;
	}
	public void setCalorie_per_unit(String calorie_per_unit) {
		this.calorie_per_unit = calorie_per_unit;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
}
