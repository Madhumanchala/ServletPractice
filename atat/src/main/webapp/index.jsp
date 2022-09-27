<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<style>
.form-control {
    display: block;
    width: 40%;
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    line-height: 1.5;
    color: purple;
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

   <div class="card">
  <div class="card-body" >
  
  <div class="mb-3">
<form action="addemployee" method="post" enctype="multipart/form-data">
  <div class="mb-3">
    <label  class="form-label">First Name</label>
    <input type="text" class="form-control" id="firstName" name="firstName" aria-describedby="emailHelp">
    
  </div>
  
  <div class="mb-3">
    <label  class="form-label">Last Name</label>
    <input type="text" class="form-control" id="lastName" name="lastName">
  </div>
  
  <div class="mb-3">
    <label  class="form-label">Address</label>
    <input type="text" class="form-control" id="address" name="address">
  </div>
  
  <div class="mb-3">
    <label  class="form-label">Designation</label>
    <input type="text" class="form-control" id="designation" name="designation">
  </div>
  
  <div class="mb-3">
    <label  class="form-label">Choose file</label>
    <input type="file" class="form-control" id="image" name="image">
  </div>
  
  
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  
  
  <button type="submit" class="btn btn-primary">SaveEmployee</button>
  
  
</form>
</div>

<div class="mb-3 form-check">
<form method="get" action="getemployee">
<button type="submit" class="btn btn-primary">EmployeeList</button>
</form>
</div>
    
  </div>
</div>

        
        
</body>


</html>