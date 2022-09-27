package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logincheck")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

		Student e = new Student();
		e.setEmail(email);
		e.setPassword(password);
		
		HttpSession session = request.getSession();  

		try {
			
			Connection con = StudentDao.getconection();

			PreparedStatement ps = con.prepareStatement("select COUNT(*) from student where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int Countrow = Integer.parseInt(rs.getString(1));
			if (Countrow==0) { 

				String error="You have not registered, please register first";
				request.setAttribute("PLEAS",error );
				  RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
			        rd.include(request, response);  
			}
			else if(Countrow==1){
				if (StudentDao.Validate(e)) {
					response.sendRedirect("loginsuccess.jsp");
				} 
				else {
					String mn="Invalid Username or Password";
					request.setAttribute("Errormsg",mn );
					  RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
				        rd.include(request, response);  
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
