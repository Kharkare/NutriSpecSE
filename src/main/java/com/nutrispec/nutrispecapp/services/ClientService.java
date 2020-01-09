package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;

import com.nutrispec.nutrispecapp.models.Association;
import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.Nutritionist;
import com.nutrispec.nutrispecapp.models.NutritionistRatings;

public class ClientService {
	
	private Connection conn;
	
	public ClientService(Connection conn) {
		this.conn = conn;
	}
	
	public void registerClient(Client client) throws SQLException {
		
		final String insertQuery = "INSERT INTO tbl_client (id, name, email, weight, height, gender, bmi, password, age, bloodgroup, profilepic) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepareStmt = conn.prepareStatement(insertQuery);
		prepareStmt.setString(1, null);
		prepareStmt.setString(2, client.getName());
		prepareStmt.setString(3, client.getEmail());
		prepareStmt.setString(4, client.getWeight());
		prepareStmt.setString(5, client.getHeight());
		prepareStmt.setString(6, client.getGender());
		prepareStmt.setString(7, client.getBmi());
		prepareStmt.setString(8, client.getPassword());
		prepareStmt.setString(9, client.getAge());
		prepareStmt.setString(10, client.getBloodgroup());
		prepareStmt.setString(11, null);
		
		int stmtInsertSuccess = prepareStmt.executeUpdate();
		
	}
	
	public void addRatings(String clientid, NutritionistRatings ratings) throws SQLException {
		
		final String insertQuery = "INSERT INTO tbl_ratings (id, client, nutritionist, ratings_number, ratings_text) VALUES (?,?,?,?,?)";
		PreparedStatement prepareStmt = conn.prepareStatement(insertQuery);
		prepareStmt.setString(1, null);
		prepareStmt.setInt(2, Integer.parseInt(ratings.getClientId()));
		prepareStmt.setInt(3, Integer.parseInt(ratings.getNutritionistId()));
		prepareStmt.setString(4, ratings.getRatingsInNumbers());
		prepareStmt.setString(5, ratings.getRatingsText());
		prepareStmt.execute();
	}

	public void enroll(Association association) throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		final String insertQuery = "INSERT INTO tbl_client_nutritionist_association (id, client_id, nutritionist_id) VALUES (?,?,?)";
		PreparedStatement prepareStmt = conn.prepareStatement(insertQuery);
		prepareStmt.setString(1, null);
		prepareStmt.setInt(2, Integer.parseInt(association.getClient().getId()));
		prepareStmt.setInt(3, Integer.parseInt(association.getNutritionist().getId()));
		prepareStmt.execute();
	}

	public void unroll(Association association) throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		final String query = "DELETE FROM tbl_client_nutritionist_association WHERE client_id=? AND nutritionist_id=?";
		PreparedStatement prepareStmt = conn.prepareStatement(query);
		prepareStmt.setInt(2, Integer.parseInt(association.getClient().getId()));
		prepareStmt.setInt(3, Integer.parseInt(association.getNutritionist().getId()));
		prepareStmt.execute();
	}

}
