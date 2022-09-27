package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileLocation = "/home/comunus-user33/Documents/ServletPractice/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/FileUpload(defaultpath)/WEB-INF/images/image092.jpg"; // change the path according to you
		File file = new File(fileLocation);
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			ServletOutputStream sos = resp.getOutputStream();
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment;filename=" + fileLocation);
			byte[] buffer = new byte[4096];

			while ((fis.read(buffer, 0, 4096)) != -1) {
				sos.write(buffer, 0, 4096);
			}
			fis.close();
		}
		else {
			System.out.println("NOT THERE FILE OK ");
			 RequestDispatcher rd=req.getRequestDispatcher("/success.jsp");  
		        rd.include(req, resp);  
		}
	}

}