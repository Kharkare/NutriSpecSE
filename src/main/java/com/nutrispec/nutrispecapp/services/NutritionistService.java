package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nutrispec.nutrispecapp.models.Association;
import com.nutrispec.nutrispecapp.models.Client;
import com.nutrispec.nutrispecapp.models.Nutritionist;

public class NutritionistService {
	
	private Connection conn;
	
	public NutritionistService(Connection conn) {
		this.conn = conn;
	}
	
	public void registerClient(Nutritionist nutritionist) throws SQLException {
		
		final String insertQuery = "INSERT INTO tbl_nutritionist (id, name, email, password, specializations, address, city, pincode, qualification, about, operatingHours, operatingDays) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepareStmt = conn.prepareStatement(insertQuery);
		prepareStmt.setString(1, null);
		prepareStmt.setString(2, nutritionist.getName());
		prepareStmt.setString(3, nutritionist.getEmail());
		prepareStmt.setString(4, nutritionist.getPassword());
		prepareStmt.setString(5, nutritionist.getSpecializations());
		prepareStmt.setString(6, nutritionist.getAddress());
		prepareStmt.setString(7, nutritionist.getCity());
		prepareStmt.setString(8, nutritionist.getPincode());
		prepareStmt.setString(9, nutritionist.getQualification());
		prepareStmt.setString(10, nutritionist.getAbout());
		prepareStmt.setString(11, nutritionist.getOperatingHours());
		prepareStmt.setString(12, nutritionist.getOperatingDays());
		
		int stmtInsertSuccess = prepareStmt.executeUpdate();
		
	}

	public List<Client> getClients(Nutritionist nutritionist) throws SQLException {
		// TODO Auto-generated method stub
		List<Client> all_clients = new ArrayList<Client>();
		final String query = "SELECT clt.* FROM tbl_client_nutritionist_association asso INNER JOIN tbl_client clt ON asso.client_id = clt.id WHERE asso.nutritionist_id = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, Integer.parseInt(nutritionist.getId()));
		ResultSet result = stmt.executeQuery();
		
		while(result.next()) {
			Client client = new Client();
			client.setId(String.valueOf(result.getInt("id")));
			client.setName(result.getString("name"));
			client.setAge(result.getString("age"));
			client.setBloodgroup(result.getString("bloodgroup"));
			client.setBmi(result.getString("bmi"));
			client.setEmail(result.getString("email"));
			client.setGender(result.getString("gender"));
			client.setHeight(result.getString("height"));
			client.setWeight(result.getString("weight"));
			client.setProfilepic(result.getString("profilepic"));
			client.setPassword("");
			all_clients.add(client);
		}
		result.close();
		return all_clients;
	}

	public void unroll(Association association) throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		final String query = "DELETE FROM tbl_client_nutritionist_association WHERE client_id=? AND nutritionist_id=?";
		PreparedStatement prepareStmt = conn.prepareStatement(query);
		prepareStmt.setInt(1, Integer.parseInt(association.getClient().getId()));
		prepareStmt.setInt(2, Integer.parseInt(association.getNutritionist().getId()));
		prepareStmt.execute();
	}
	
	
}
