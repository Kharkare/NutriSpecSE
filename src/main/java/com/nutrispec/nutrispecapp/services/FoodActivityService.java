package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.FoodActivity;
import com.nutrispec.nutrispecapp.models.FoodDictionary;
import com.nutrispec.nutrispecapp.models.Report;
import com.nutrispec.nutrispecapp.models.Unit;

public class FoodActivityService  {
	
	Connection conn;
	
	public FoodActivityService(Connection conn) {
		this.conn = conn;
	}
	
	public List<FoodActivity> getAllFoodActivities(Client client) throws NumberFormatException, SQLException{
		List<FoodActivity> list_food_activity = new ArrayList<FoodActivity>();
		String query = "SELECT f.*,dict.id AS dict_id, dict.food_name AS food_name, dict.food_desc AS food_desc, dict.calorie_per_unit AS cal_per_unit, dict.unit_id AS unit_id, unit.unit_name AS unit_name, unit.unit_desc AS unit_desc FROM tbl_client_food_activity f INNER JOIN tbl_food_dictionary as dict ON f.food_id = dict.id INNER JOIN tbl_food_unit AS unit ON unit.id = dict.unit_id WHERE f.client_id = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, Integer.parseInt(client.getId()));
		ResultSet result = stmt.executeQuery();
		while(result.next()) {
			FoodActivity food_activity = new FoodActivity();
			food_activity.setId(String.valueOf(result.getInt("id")));
			food_activity.setClient(client);
			food_activity.setQuantity(result.getString("quantity"));
			food_activity.setActivity_date(String.valueOf(result.getDate("activity_date")));
			food_activity.setActivity_time(result.getString("activity_time"));
			Unit unit = new Unit();
			FoodDictionary dictionary = new FoodDictionary();
			dictionary.setCalorie_per_unit(result.getString("cal_per_unit"));
			dictionary.setId(String.valueOf(result.getInt("dict_id")));
			dictionary.setFoodDesc(result.getString("food_desc"));
			dictionary.setFoodName(result.getString("food_name"));
			unit.setId(String.valueOf(result.getInt("unit_id")));
			unit.setUnit_desc(result.getString("unit_desc"));
			unit.setUnit_name(result.getString("unit_name"));
			dictionary.setUnit(unit);
			food_activity.setFood_dictionary(dictionary);
			list_food_activity.add(food_activity);
		}
		return list_food_activity;
	}
	
	public FoodActivity addFoodActivity(FoodActivity food_activity) throws SQLException {
		
		String query = "INSERT INTO tbl_client_food_activity (id, food_id, client_id, activity_date, activity_time, quantity) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, null);
		stmt.setInt(2, Integer.parseInt(food_activity.getFood_dictionary().getId()));
		stmt.setInt(3, Integer.parseInt(food_activity.getClient().getId()));
		stmt.setDate(4, java.sql.Date.valueOf(food_activity.getActivity_date()));
		stmt.setString(5, food_activity.getActivity_time());
		stmt.setString(6, food_activity.getQuantity());
		
		stmt.execute();
		
		return food_activity;
	}
	
	public Report getAllFoodActivitiesAsPerDate(Report report) throws SQLException {
		List<FoodActivity> list_food_activity = new ArrayList<FoodActivity>();
		String query = "SELECT f.*,dict.id AS dict_id, dict.food_name AS food_name, dict.food_desc AS food_desc, dict.calorie_per_unit AS cal_per_unit, dict.unit_id AS unit_id, unit.unit_name AS unit_name, unit.unit_desc AS unit_desc FROM tbl_client_food_activity f INNER JOIN tbl_food_dictionary as dict ON f.food_id = dict.id INNER JOIN tbl_food_unit AS unit ON unit.id = dict.unit_id WHERE f.activity_date >= ? AND f.activity_date <= ? AND f.client_id = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setDate(1, java.sql.Date.valueOf(report.getFromDate()));
		stmt.setDate(2, java.sql.Date.valueOf(report.getToDate()));
		stmt.setInt(3, Integer.parseInt(report.getClient_id()));
		ResultSet result = stmt.executeQuery();
		while(result.next()) {
			FoodActivity food_activity = new FoodActivity();
			food_activity.setId(String.valueOf(result.getInt("id")));
			food_activity.setClient(null);
			food_activity.setQuantity(result.getString("quantity"));
			food_activity.setActivity_date(String.valueOf(result.getDate("activity_date")));
			food_activity.setActivity_time(result.getString("activity_time"));
			Unit unit = new Unit();
			FoodDictionary dictionary = new FoodDictionary();
			dictionary.setCalorie_per_unit(result.getString("cal_per_unit"));
			dictionary.setId(String.valueOf(result.getInt("dict_id")));
			dictionary.setFoodDesc(result.getString("food_desc"));
			dictionary.setFoodName(result.getString("food_name"));
			unit.setId(String.valueOf(result.getInt("unit_id")));
			unit.setUnit_desc(result.getString("unit_desc"));
			unit.setUnit_name(result.getString("unit_name"));
			dictionary.setUnit(unit);
			food_activity.setFood_dictionary(dictionary);
			list_food_activity.add(food_activity);
		}
		report.setFood_activity(list_food_activity);
		return report;
	}

}
