package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String firstname=request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		String phonenum = request.getParameter("phonenum");
		Long phone = Long.parseLong(phonenum);
		
		String country=request.getParameter("country");
		String password=request.getParameter("password");
		
		
		Student e = new Student();
		e.setFirstname(firstname);
		e.setLastname(lastname);
		e.setEmail(email);
		e.setPhonenum(phone);
		e.setCountry(country);
		e.setPassword(password);
		
		
		int status = StudentDao.save(e);
		if(status>0)
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
			out.print("<p>Record saved successfully!</p>");
		}
		else {
			out.print("<p>Record NOT  saved successfully!</p>");
		}
		
		
		
		
		
		
		
		
		
		

	}
}
