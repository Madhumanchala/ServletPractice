<%@page import="java.util.Iterator"%>
<%@page import="pojo.EmployeeDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.EmployeeDaoImpl"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css -->
<style>
.form-control {
	display: block;
	width: 40%;
	padding: 0.375rem 0.75rem;
	font-size: 1rem;
	line-height: 1.5;
	color: #495057;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
	border-radius: 0.25rem;
	transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

.card {
	position: relative;
	display: -webkit-box;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-orient: vertical;
	-webkit-box-direction: normal;
	-ms-flex-direction: column;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #00bcd4;
	background-clip: border-box;
	border: 1px solid rgba(0, 0, 0, .125);
	border-radius: 0.25rem;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>

</head>
<body>

	<div class="card">
		<div class="card-body">

			<table border=2 style="width: 100%">
				<tr style="height: 50px">
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Designation</th>
					<th>Image</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<%
				List<EmployeeDetails> emplist = (List) request.getAttribute("employeelistdetail");
				Iterator<EmployeeDetails> it = emplist.iterator();
				while (it.hasNext()) {

					EmployeeDetails employeedetails = it.next();
				%>
				<tr style="height: 50px">
					<td><%=employeedetails.getId()%></td>
					<td><%=employeedetails.getFirstName()%></td>
					<td><%=employeedetails.getLastName()%></td>
					<td><%=employeedetails.getAdress()%></td>
					<td><%=employeedetails.getDesignmation()%></td>
					<td><img
						src="data:image/jpg;base64,<%=employeedetails.getBase64Image()%>"
						width="75" height="75" /></td>
					<td><a href="edit.jsp?id=<%=employeedetails.getId()%>">Edit</a></td>
					<td><a href="delete?id=<%=employeedetails.getId()%>">Delete</a>
					</td>

				</tr>
				<%
				}
				%>

			</table>
			<td><a href="index.jsp"> Add New Employee </a></td>



		</div>
	</div>
</body>
</html>