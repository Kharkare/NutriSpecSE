package com.nutrispec.nutrispecapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	
}
