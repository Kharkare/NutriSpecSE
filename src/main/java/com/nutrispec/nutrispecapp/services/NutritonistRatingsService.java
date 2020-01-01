package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nutrispec.nutrispecapp.models.NutritionistRatings;

public class NutritonistRatingsService {

	private Connection conn;
	
	public NutritonistRatingsService(Connection conn) {
		this.conn = conn;
	}
	
	public void addRatings(final NutritionistRatings ratings) throws SQLException {
		final String query = "";
		PreparedStatement stmt = conn.prepareStatement(query);
		
	}
	
}
