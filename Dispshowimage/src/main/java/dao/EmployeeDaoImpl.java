package dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.catalina.connector.Response;

import connectivity.CheckConnection;
import pojo.EmployeeDetails;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection con = CheckConnection.getConnect();

	@Override
	public boolean addEmployee(EmployeeDetails employeeDetails) {
		try {
			System.out.println("hi this sanket");
			String sql = "insert into employeedetails (firstName,lastName,address,designation,image) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employeeDetails.getFirstName());
			ps.setString(2, employeeDetails.getLastName());
			ps.setString(3, employeeDetails.getAdress());
			ps.setString(4, employeeDetails.getDesignmation());
			ps.setBlob(5, employeeDetails.getInputstream());

			int row = ps.executeUpdate();
			if (row > 0) {
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<EmployeeDetails> getAllEmployee() {
		System.out.println("hi this sanket in ");
		List<EmployeeDetails> alist = new ArrayList<>();
		try {
			String sql = "select * from employeedetails";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeDetails employeeDetails = new EmployeeDetails();

				System.out.println(rs.getString(2));
				employeeDetails.setId(rs.getInt(1));
				employeeDetails.setFirstName(rs.getString(2));
				employeeDetails.setLastName(rs.getString(3));
				employeeDetails.setAdress(rs.getString(4));
				employeeDetails.setDesignmation(rs.getString(5));

				Blob blob = rs.getBlob(6);
				InputStream inputStream = blob.getBinaryStream();

				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();

				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				employeeDetails.setBase64Image(base64Image);

				inputStream.close();
				outputStream.close();

				alist.add(employeeDetails);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return alist;
	}

	public EmployeeDetails searchEmployeeById(int empid) {

		EmployeeDetails employeedetails = null;
		try {
			String sql = "select * from employeedetails where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employeedetails = new EmployeeDetails();
				employeedetails.setId(rs.getInt(1));
				employeedetails.setFirstName(rs.getString(2));
				employeedetails.setLastName(rs.getString(3));
				employeedetails.setAdress(rs.getString(4));
				employeedetails.setDesignmation(rs.getString(5));

				Blob blob = rs.getBlob(6);
				InputStream inputStream = blob.getBinaryStream();

				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();

				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				employeedetails.setBase64Image(base64Image);

				inputStream.close();
				outputStream.close();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return employeedetails;

	}

	@Override
	public boolean updateEmployee(EmployeeDetails employeeDetails) {

		try {
			String sql = "update employeedetails set firstName=?,lastName=?,address=?,designation=?,image=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employeeDetails.getFirstName());
			ps.setString(2, employeeDetails.getLastName());
			ps.setString(3, employeeDetails.getAdress());
			ps.setString(4, employeeDetails.getDesignmation());
			ps.setBlob(5, employeeDetails.getInputstream());
			ps.setInt(6, employeeDetails.getId());

			int row = ps.executeUpdate();
			if (row > 0) {
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean deleteEmployee(int id) {

		try {
			String sql = "delete from employeedetails where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int row = ps.executeUpdate();
			if (row > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

}
