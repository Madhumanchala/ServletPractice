<%@page import="dao.EmployeeDaoImpl"%>
<%@page import="java.util.Iterator"%>
<%@page import="pojo.EmployeeDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


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
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
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
    border: 1px solid rgba(0,0,0,.125);
    border-radius: 0.25rem;
}
</style>


</head>
<body>
<div class="container">
        <h1>Employee Details</h1>
        
        <%
        
        int empId=Integer.parseInt(request.getParameter("id")); 
        EmployeeDaoImpl empl=new EmployeeDaoImpl();
        EmployeeDetails empdetails=empl.searchEmployeeById(empId);
       
        %>
        <form action="updateEmployee" method="post">
            <table>
                <tr>
                    <td>Employee Id</td>
                    <td><input type="text" name="empId" id="empId" value=<%= empdetails.getId() %> /></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="firstName" id="firstName" value=<%= empdetails.getFirstName() %> /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" id="lastName" value=<%= empdetails.getLastName() %> /></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" id="address" value=<%= empdetails.getAdress() %> /></td>
                </tr>
                <tr>
                    <td>Designation</td>
                    <td><input type="text" name="designation" id="designation" value=<%= empdetails.getDesignmation() %> /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="SaveEmployee"  /></td>
                    
                    
                </tr>
            
            </table>
        </form>
        
        </div>
        

</body>
</html>