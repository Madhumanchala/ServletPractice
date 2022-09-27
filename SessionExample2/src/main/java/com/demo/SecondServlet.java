package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			Cookie ck[] = request.getCookies();
			out.print("Hello " + ck[0].getValue());
			
			HttpSession session=request.getSession(false);  
	        String n=(String)session.getAttribute("uname1");  
	        out.print("Hello session ok  "+n);  

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}