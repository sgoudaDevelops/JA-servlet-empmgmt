<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Softtek Employe Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a class="navbar-brand">Softek Employe Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Home</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<h2>Add New User</h2>

				<form action="insert" method="post">
					<fieldset class="form-group">
						<label>first_name</label> <input type="text" value=""
							class="form-control" name="first_name" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>last_name</label> <input type="text" value=""
							class="form-control" name="last_name">
					</fieldset>

					<fieldset class="form-group">
						<label>address</label> <input type="text" value=""
							class="form-control" name="address">
					</fieldset>
					<fieldset class="form-group">
						<label>birth_date</label> <input type="date" value=""
							class="form-control" name="birth_date">
					</fieldset>
					<fieldset class="form-group">
						<label>gender</label> <input type="text" value=""
							class="form-control" name="gender">

						<fieldset class="form-group">
							<label>emp_type</label> <input type="text" value=""
								class="form-control" name="emp_type">
						</fieldset>
						<fieldset class="form-group">
							<label>emp_status</label> <input type="text" value=""
								class="form-control" placeholder="emp_status" name="emp_status">
								
						</fieldset>
						<fieldset class="form-group">
							<label>contactno</label> <input type="tel" pattern="^[0-9]{10}"
								class="form-control" name="contactno">
						</fieldset>
						<fieldset class="form-group">
							<label>exp_level</label> <input type="text" value=""
								class="form-control" name="exp_level">
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>