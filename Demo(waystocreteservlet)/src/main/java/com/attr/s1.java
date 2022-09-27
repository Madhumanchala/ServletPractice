package com.attr;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class s1 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {

			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
			  HttpSession session = req.getSession();
			  session.setAttribute("name", "MADHU");
			  session.setAttribute("last", "KAMAL");


			ServletContext context = getServletContext();
			context.setAttribute("company", "IBM");

			out.println("Welcome to first servlet");
			out.println("<a href='s2'>visit</a>");
			out.close();

		} catch (Exception e) {
		}

	}

}
