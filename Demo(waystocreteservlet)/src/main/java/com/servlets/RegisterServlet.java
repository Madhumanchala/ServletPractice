package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>This is get of myservice </h1>");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		String cond = request.getParameter("condition");

		ServletContext context=getServletContext();  
		String n=(String)context.getAttribute("company");  
		
		System.out.println(n);
		System.out.println(context);
		
		
		if (cond != null)
			if (cond.equals("checked")) {
				out.println("<h2> NAME : " + name + " </h2>");
				out.println("<h2> password : " + password + " </h2>");

				out.println("<h2> email : " + email + " </h2>");
				out.println("<h2> country : " + country + " </h2>");
				
				// below one is forward method of RequestDispatcher
				RequestDispatcher rd=request.getRequestDispatcher("succes");
						rd.forward(request, response);
				
				
			} else {
				out.println("<h2> you have Not accepted terms and conditions ok </h2>");
			}
		else {
			out.println("<h2> you have Not accepted terms and conditions ok </h2>");
			
			// below one is include method of RequestDispatcher		
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}

	}
	

	


}
