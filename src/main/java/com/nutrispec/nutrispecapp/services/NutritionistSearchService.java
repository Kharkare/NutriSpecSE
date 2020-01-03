package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.Nutritionist;
import com.nutrispec.nutrispecapp.models.NutritionistRatings;
import com.nutrispec.nutrispecapp.models.NutritionistSearch;

public class NutritionistSearchService {
	
	private Connection conn;
	
	public NutritionistSearchService(Connection conn) {
		this.conn = conn;
	}
	
	public NutritionistSearch searchNutritionist(NutritionistSearch search) throws SQLException {
		List<Nutritionist> listOfNutritionist = new ArrayList<Nutritionist>();
		final String selectQuery = "SELECT * FROM tbl_nutritionist WHERE name LIKE ? OR city LIKE ? OR qualification LIKE ? OR specializations LIKE ?";
		PreparedStatement prepareStmt = conn.prepareStatement(selectQuery);
		prepareStmt.setString(1, "%"+search.getName()+"%");
		prepareStmt.setString(2, "%"+search.getCity()+"%");
		prepareStmt.setString(3, "%"+search.getQualification()+"%");
		prepareStmt.setString(4, "%"+search.getSpecialization()+"%");
		ResultSet result = prepareStmt.executeQuery();
		while(result.next()) {
			Nutritionist nutritionist = new Nutritionist();
			nutritionist.setId(String.valueOf(result.getInt("id")));
			nutritionist.setName(result.getString("name"));
			nutritionist.setEmail(result.getString("email"));;
			nutritionist.setSpecializations(result.getString("specializations"));
			nutritionist.setAddress(result.getString("address"));
			nutritionist.setCity(result.getString("city"));
			nutritionist.setPincode(result.getString("pincode"));
			nutritionist.setQualification(result.getString("qualification"));
			nutritionist.setAbout(result.getString("about"));
			nutritionist.setOperatingHours(result.getString("operatingHours"));
			nutritionist.setOperatingDays(result.getString("operatingDays"));
			nutritionist.setNutritionistRatings(getRatings(nutritionist));
			listOfNutritionist.add(nutritionist);
		}
		result.close();
		search.setSearchResult(listOfNutritionist);
		return search;
	}
	
	private List<NutritionistRatings> getRatings(Nutritionist nutritionist) throws SQLException{
		List<NutritionistRatings> listOfratings = new ArrayList<NutritionistRatings>();
		final String selectQuery = "SELECT r.id AS ratings_id, r.client AS ratings_client, r.nutritionist AS ratings_nutritionist, r.ratings_number AS ratings_number, r.ratings_text AS ratings_text, c.* FROM tbl_ratings AS r INNER JOIN tbl_client AS c ON c.id = r.client WHERE r.nutritionist = ?";
		PreparedStatement prepareStmt = conn.prepareStatement(selectQuery);
		prepareStmt.setInt(1, Integer.parseInt(nutritionist.getId()));
		ResultSet result = prepareStmt.executeQuery();
		
		while(result.next()) {
			Client client = new Client();
			NutritionistRatings ratings = new NutritionistRatings();
			ratings.setId(String.valueOf(result.getInt("ratings_id")));
			ratings.setRatingsInNumbers(result.getString("ratings_number"));
			ratings.setRatingsText(result.getString("ratings_text"));
			ratings.setNutritionistId(nutritionist.getId());
			client.setId(String.valueOf(result.getInt("ratings_client")));
			client.setName(result.getString("name"));
			client.setEmail(result.getString("email"));
			client.setWeight(result.getString("weight"));
			client.setHeight(result.getString("height"));
			client.setGender(result.getString("gender"));
			client.setBmi(result.getString("bmi"));
			client.setAge(result.getString("age"));
			client.setBloodgroup(result.getString("bloodgroup"));
			client.setProfilepic(result.getString("profilepic"));
			ratings.setClient(client);
			listOfratings.add(ratings);
		}
		result.close();
		return listOfratings;
	}

}
