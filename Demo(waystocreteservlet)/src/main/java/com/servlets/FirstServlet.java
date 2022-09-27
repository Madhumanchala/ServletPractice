package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("created object");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		System.out.println("Service is here ");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>THIS IS MY OUTPUT FROM SERVICE METHOD OK" + " </h1>");

	}

	@Override
	public void destroy() {
		System.out.println("Destroy here ");
	}

	@Override
	public ServletConfig getServletConfig() {

		return this.config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("this creted by madhu manchala");
		return null;
	}

}
