//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import connectivity.CheckConnection;
//
//public class LoginDaoImpl implements LoginDao {
//	
//	//Connection con=CheckConnection.getConnection();
//
//	@Override
//	public boolean userLogin(String custEmailId, String custPassword) {
//		
//		try {
//			String sql="select * from customer where EmailId=? and password=?";
//			PreparedStatement ps=con.prepareStatement(sql);
//			ps.setString(1, custEmailId);
//			ps.setString(2, custPassword);
//			
//			ResultSet rs=ps.executeQuery();
//			if(rs.next()) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}catch(SQLException s) {
//			s.printStackTrace();
//		}
//		return false;
//	}
//
//}
