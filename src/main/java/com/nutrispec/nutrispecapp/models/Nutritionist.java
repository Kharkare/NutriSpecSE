package com.nutrispec.nutrispecapp.models;

import java.util.List;

public class Nutritionist {
	
	private String id;
	private String name;
	private String about;
	private String email;
	private String specializations;
	private String address;
	private String city;
	private String pincode;
	private String qualification;
	private String operatingHours;
	private String operatingDays;
	private String password;
	private List<NutritionistRatings> NutritionistRatings;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSpecializations() {
		return specializations;
	}
	public void setSpecializations(String specializations) {
		this.specializations = specializations;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getOperatingHours() {
		return operatingHours;
	}
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}
	public String getOperatingDays() {
		return operatingDays;
	}
	public void setOperatingDays(String operatingDays) {
		this.operatingDays = operatingDays;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public List<NutritionistRatings> getNutritionistRatings() {
		return NutritionistRatings;
	}
	public void setNutritionistRatings(List<NutritionistRatings> nutritionistRatings) {
		NutritionistRatings = nutritionistRatings;
	}
	
}
