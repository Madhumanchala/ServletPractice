package com.demo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/upload")
public class FileUploadHandler extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String contextPath = request.getServletContext().getRealPath("/WEB-INF/images");
		System.out.println("contextPath : " + contextPath);

		File folder = new File(contextPath);
		File[] listOfFiles = folder.listFiles();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// process only if its multipart content
		if (ServletFileUpload.isMultipartContent(request)) {

			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						System.out.println("image name " + item.getName());

						String fileLocation = "/home/comunus-user33/Documents/ServletPractice/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/FileUpload(defaultpath)/WEB-INF/images/"
								+ name; // change the path according to you
						File file = new File(fileLocation);
						if (!file.exists()) {
							item.write(new File(contextPath + File.separator + name));
							// File uploaded successfully
							request.getRequestDispatcher("/result.jsp").forward(request, response);
							out.print("<p>Record saved successfully!</p>");
						} else {
							out.println("file exist alredy ");
						}

					}
				}
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to " + ex);
				out.print("<p>nottttttttt Record saved successfully!</p>");
			}
		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}

	}

}