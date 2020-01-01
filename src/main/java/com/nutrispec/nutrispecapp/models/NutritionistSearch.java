package com.nutrispec.nutrispecapp.models;

import java.util.List;

public class NutritionistSearch {
	
	private String name;
	private String city;
	private String specialization;
	private String qualification;
	private List<Nutritionist> searchResult;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public List<Nutritionist> getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(List<Nutritionist> searchResult) {
		this.searchResult = searchResult;
	}
	

}
