package com.demo;

import java.io.File;
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

@WebServlet("/Usernamecheck")
public class Usernamecheck extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phonenum = request.getParameter("phonenum");
		Long phone = Long.parseLong(phonenum);
		String country = request.getParameter("country");
		String password = request.getParameter("password");

		try {
			Connection con = StudentDao.getconection();

			PreparedStatement ps = con.prepareStatement("select COUNT(*)  from student where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int Countrow = Integer.parseInt(rs.getString(1));
			System.out.println(Countrow);
			if (Countrow==(0)) {

				int status = 0;
				try {
					Student e = new Student();
					e.setFirstname(firstname);
					e.setLastname(lastname);
					e.setEmail(email);
					e.setPhonenum(phone);
					e.setCountry(country);
					e.setPassword(password);
					Connection cons = StudentDao.getconection();
					PreparedStatement pss = cons.prepareStatement(
							"insert into student (firstname, lastname, email, phonenum, country, password) values (?, ?, ?, ?, ?, ?)");
					pss.setString(1, e.getFirstname());
					pss.setString(2, e.getLastname());
					pss.setString(3, e.getEmail());
					pss.setLong(4, e.getPhonenum());
					pss.setString(5, e.getCountry());
					pss.setString(6, e.getPassword());
					status = pss.executeUpdate();
					con.close();
					out.println("registration done ");
					String success = "You are registered Successfully";
					request.setAttribute("suc", success);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.include(request, response);

				} catch (Exception ex) {
					System.out.println(ex);
					ex.printStackTrace();
				}
			} else {
				String emai = "This email is alredy registered ";
				request.setAttribute("em", emai);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
			}
		} catch (Exception ex) {
		}

	}

}
