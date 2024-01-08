package com.demo.qrcode.simple.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.qrcode.simple.project.connection.AdminConnection;
import com.demo.qrcode.simple.project.dto.Admin;

public class AdminDao {

	Connection connection = AdminConnection.getConnection();

	
	// saveAdmin method ...
	public Admin saveAdmin(Admin admin) {

		String insertQuery = "insert into admin values(?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, admin.getAdminId());
			preparedStatement.setString(2, admin.getAdminName());
			preparedStatement.setString(3, admin.getAdminEmail());
			preparedStatement.setLong(4, admin.getAdminPhone());
			preparedStatement.setString(5, admin.getAdminPassword());

			preparedStatement.execute();

			return admin;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// get admins details
	public List<Admin> getAllAdmin() {

		String displayAdminQuery = "select * from admin";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayAdminQuery);
			ResultSet resultSet = preparedStatement.executeQuery();

			List<Admin> admins = new ArrayList<Admin>();
			while (resultSet.next()) {
				Admin admin = new Admin();

				admin.setAdminId(resultSet.getInt("adminId"));
				admin.setAdminEmail(resultSet.getString("adminEmail"));
				admin.setAdminPassword(resultSet.getString("adminPassword"));

				admins.add(admin);
			}
			return admins;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * getAllDataByEmail
	 */
	public Admin getAdminByEmail(String adminEmail) {
		
		List<Admin> admins=getAllAdmin();
		
		for (Admin admin : admins) {
			if (adminEmail.equals(admin.getAdminEmail())) {
				return admin;
			}
		}
		return null;
	}
}
