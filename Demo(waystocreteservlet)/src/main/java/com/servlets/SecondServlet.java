package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("this is GENERIC SERVELT");
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h1>THIS IS MY OUTPUT from second servlet generic ok "
				+ " </h1>");
	}

}
