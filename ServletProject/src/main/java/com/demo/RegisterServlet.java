package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User userModel = new User(name, email, password);

		UserDatabase regUser = new UserDatabase(DataCon.getConnection());
		if (regUser.saveUser(userModel)) {
			response.sendRedirect("index.jsp");
		} else {
			String errorMessage = "User Available";
			HttpSession regSession = request.getSession();
			regSession.setAttribute("RegError", errorMessage);
			response.sendRedirect("Registration.jsp");
		}

	}

}
