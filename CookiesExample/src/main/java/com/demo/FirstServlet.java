package com.demo;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
  
public class FirstServlet extends HttpServlet {  
	
	private int iHitCounter;

	// init method just initializes the hitCounter to zero
	public void init() throws ServletException {
		iHitCounter = 0;
	}
  
  public void doPost(HttpServletRequest request, HttpServletResponse response){  
    try{  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userName");  
    out.print("Welcome "+n);  
    
//    HttpSession session=request.getSession();  
//    session.setAttribute("uname1",n);  
    
    

  
    Cookie ck=new Cookie("uname",n);//creating cookie object  
    response.addCookie(ck);//adding cookie in the response  
  
    //creating submit button  
    out.print("<form action='SecondServlet'>");  
    out.println("You are visited this site: " + (++iHitCounter) + "  times");
    out.print("<input type='submit' value='go'>");  
    out.print("</form>");  
          
    out.close();  
  
        }catch(Exception e){System.out.println(e);}  
  }  
}  