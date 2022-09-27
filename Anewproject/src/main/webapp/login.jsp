<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style>
body {
	font-family: 'Poiret One', cursive;
	background: #3494E6; /* fallback for old browsers */
	background: -webkit-linear-gradient(to right, #EC6EAD, #3494E6);
	/* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to right, #EC6EAD, #3494E6);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

h4 {
	font-weight: bold;
	margin-bottom: 2.5rem;
}

.form-wrapper {
	background: #fff;
	border-radius: 5px;
	padding: 50px;
}

.form-control, .custom-select {
	border-radius: 0px;
	color: #495057;
	background-color: #f1f1f1;
	border-color: none;
}

.form-control:focus {
	color: #495057;
	background-color: #ffffff;
	border: 1px solid #b5b6b3;
	outline: 0;
	box-shadow: none;
}

.btn {
	background: #3494E6;
	border: #3494E6;
	padding: 0.6rem 3rem;
	font-weight: bold;
}

.btn:hover, .btn:focus, .btn:active, .btn-primary:not(:disabled):not(.disabled).active,
	.btn-primary:not(:disabled):not(.disabled):active, .show>.btn-primary.dropdown-toggle
	{
	background: #3494E6;
	border: #3494E6;
	outline: 0;
}
</style>
</head>
<body>
	<section class="contact-from pt-4">
		<div class="container">

			<div class="row mt-5">
				<div class="col-md-7 mx-auto">
					<div class="form-wrapper">
						<div class="row">
							<div class="col-md-12">
								<h5>${PLEAS}</h5>
								<h6>${Errormsg}</h6>
								<h4>Login form</h4>
							</div>
						</div>
						<form _lpchecked="1" action="Logincheck" method="get">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" name="email"
											placeholder="email">
									</div>
								</div>

								<br/>

								<div class="col-md-6">
									<div class="form-group">
										<input type="password" class="form-control" name="password"
											placeholder="password">
									</div>
								</div>

								<div class="mt-3">
									<button class="btn btn-primary">Login</button>
								</div>

								<div class="mt-3">
									<a href='index.jsp'>Click Here Register </a>
								</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</section>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>