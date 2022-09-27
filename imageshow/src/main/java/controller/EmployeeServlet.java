package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import dao.EmployeeDaoImpl;
import pojo.EmployeeDetails;

@WebServlet("/addemployee")
@MultipartConfig(maxFileSize = 16177215)
public class EmployeeServlet extends HttpServlet {

	EmployeeDaoImpl empl = new EmployeeDaoImpl();
	InputStream inputstream = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			PrintWriter out = resp.getWriter();
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String address = req.getParameter("address");
			String designation = req.getParameter("designation");
			Part filepart = req.getPart("image");

			inputstream = filepart.getInputStream();

			EmployeeDetails employeeDetails = new EmployeeDetails(firstName, lastName, address, designation,
					inputstream);
			boolean b = empl.addEmployee(employeeDetails);

			if (b) {

				List<EmployeeDetails> emplist = empl.getAllEmployee();
				System.out.println(emplist);
				if (emplist != null && !(emplist.isEmpty())) {

					req.setAttribute("employeelistdetail", emplist);
					req.getRequestDispatcher("EmployeeList.jsp").forward(req, resp);

				}

			} else {
				resp.sendRedirect("Fail.jsp");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
