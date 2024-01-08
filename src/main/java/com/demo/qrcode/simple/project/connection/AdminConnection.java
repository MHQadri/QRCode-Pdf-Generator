package com.demo.qrcode.simple.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminConnection {

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/company";
			String user = "root";
			String pass = "root";

			return DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
