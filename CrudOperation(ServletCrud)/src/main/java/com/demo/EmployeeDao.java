package com.demo;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "admin", "comunus@123");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}

	public static int save(Employee e) {
		int status = 0;
		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into user905(name,password,email,country,checking) values (?,?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setString(5, e.getChecking());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;

	}

	public static List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();

		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user905");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static int update(Employee e) throws SQLException {
		int status = 0;
		try {

			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update user905 set name=?,password=?,email=?,country=? where id=?");

			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());

			status = ps.executeUpdate();
			con.close();
		} catch (Exception e2) {

		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {

			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from user905 where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e2) {
		}
		return status;
	}

	public static Employee getEmployeeById(int Id) {
		Employee e = new Employee();
		int status = 0;
		try {

			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user905 where id=?");
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));

				con.close();
			}

		} catch (Exception ex) {
		}
		return e;
	}
}
