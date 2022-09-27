package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {

	String dbUsername, dbPassword;

	public static Connection getconection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bookstore", "admin", "comunus@123");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Student e) {
		int status = 0;
		try {
			Connection con = StudentDao.getconection();
			PreparedStatement ps = con.prepareStatement(
					"insert into student(firstname,lastname,email,phonenum,country,password) values (?,?,?,?,?,?)");

			ps.setString(1, e.getFirstname());
			ps.setString(2, e.getLastname());
			ps.setString(3, e.getEmail());
			ps.setLong(4, e.getPhonenum());
			ps.setString(5, e.getCountry());
			ps.setString(6, e.getPassword());

			status = ps.executeUpdate();
			con.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;

	}

	public static boolean Validate(Student e) {
		try {
			Connection con = StudentDao.getconection();

			PreparedStatement ps = con.prepareStatement("select * from student where email = ? and password = ? ");

			ps.setString(1, e.getEmail());
			ps.setString(2, e.getPassword());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				e.setEmail(rs.getString(1));
				e.setPassword(rs.getString(2));

				System.out.println(e.getPassword());
				System.out.println(rs.getString(2));
				if (rs.getString(2).equals(e.getPassword()))

					con.close();

				return true;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return false;

	}

	public static boolean Validates(Student e) {
		try {
			Connection con = StudentDao.getconection();
			PreparedStatement ps = con.prepareStatement("select COUNT(*)  from student where email = ?");
			ps.setString(1, e.getEmail());
			ResultSet rs = ps.executeQuery();
			rs.next();
			String Countrow = rs.getString(1);
			if (Countrow.equals(0)) {

			} else {

			}
			con.close();

			return true;

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return false;

	}
}