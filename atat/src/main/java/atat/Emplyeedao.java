package atat;

import java.sql.Connection;
import java.sql.DriverManager;

public class Emplyeedao {
	
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

}
