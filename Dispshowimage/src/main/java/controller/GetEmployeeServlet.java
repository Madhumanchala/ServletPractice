package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDaoImpl;
import pojo.EmployeeDetails;

@WebServlet("/getemployee")
public class GetEmployeeServlet extends HttpServlet{
	
	EmployeeDaoImpl empl=new EmployeeDaoImpl();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		    List<EmployeeDetails> emplist=empl.getAllEmployee();
		    System.out.println(emplist);
		    if(emplist!=null && !(emplist.isEmpty())) {
			
			     req.setAttribute("employeelistdetail", emplist);
			     req.getRequestDispatcher("EmployeeList.jsp").forward(req, resp);
		    }
		    else {
			resp.sendRedirect("Fail.jsp");
		    }
		
			
			
			 
	}

	

}
