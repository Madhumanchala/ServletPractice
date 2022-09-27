package com.attr;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class s2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {

			res.setContentType("text/html");
			PrintWriter out = res.getWriter();

			ServletContext context = getServletContext();
			String n = (String) context.getAttribute("company");
			
			 HttpSession session = req.getSession();
			 Object m=session.getAttribute("name");
			 String p=(String) session.getAttribute("last");
			 session.removeAttribute("last");

			out.println("Welcome to " + n);
			out.println("Welcome to " + m);
			out.println("Welcome to " + p);
			out.close();

		} catch (Exception e) {
		}
	}
}
