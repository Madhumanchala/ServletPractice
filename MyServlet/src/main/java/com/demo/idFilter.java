package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class idFilter
 */
@WebFilter("/addAlien")
public class idFilter implements Filter {

    public idFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpServletRequest req=(HttpServletRequest) request;
		int aid=Integer.parseInt(request.getParameter("aid"));

		if(aid>1)
		{
			chain.doFilter(request, response);
		}
		else {
			out.println("invalid input");
		}
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
