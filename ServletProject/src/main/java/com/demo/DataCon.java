package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataCon {

	public static Connection getConnection() {
		Connection con = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bookstore", "admin", "comunus@123");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
