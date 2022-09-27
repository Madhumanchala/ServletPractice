package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SecondServlet extends HttpServlet {
	
	private int iHitCounter;

	// init method just initializes the hitCounter to zero
	public void init() throws ServletException {
		iHitCounter = 0;
	}
  

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			Cookie ck[] = request.getCookies();
			out.print("Hello " + ck[0].getValue());
		    out.println("You are  visited this site: " + (++iHitCounter)+"times ");

			
//			HttpSession session=request.getSession(false);  
//	        String n=(String)session.getAttribute("uname1");  
//	        out.print("Hello session ok  "+n);  

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}