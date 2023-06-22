<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>



<head>
<title>Softtek Employee Management Application</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style type="text/css">
input
{
	margin-right: 5%;
}
.input-group.input-group-unstyled input.form-control {
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
}

.input-group-unstyled .input-group-addon {
	border-radius: 4px;
	border: 0px;
	background-color: transparent;
}
</style>
</head>



<body>



	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User
					Management App </a>
			</div>



			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Home</a></li>
			</ul>
		</nav>
	</header>
	<br>



	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
		<div style="width: 80%; margin: auto; font-size: 18px;">
			<div style="float: left;">
				<table>

					<tr>
						<td><label>Employee Id </label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.emp_id}"/>
							readonly="readonly"><br> <br></td>
					</tr>
					<tr>
						<td><label>Firstname</label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.first_name}"/>
							readonly="readonly"><br> <br></td>
					</tr>

					<tr>
						<td><label>Lastname</label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.last_name}"/>
							readonly="readonly"><br> <br></td>
					</tr>

					<tr>
						<td><label>Address</label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.address}"/>
							readonly="readonly"><br> <br></td>
					</tr>

					<tr>
						<td><label>Date of Birth</label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.birth_date}"/>
							readonly="readonly"><br> <br></td>
					</tr>

					<tr>
						<td><label>Gender</label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.gender}"/>
							readonly="readonly"><br><br></td>
					</tr>
				</table>
			</div>


			<div style="float: right;">
				<table>

					<tr>
						<td><label>Email</label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.email}"/>
							readonly="readonly"><br> <br></td>
					</tr>

					<tr>
						<td><label>Contact Number</label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.contactno}"/>
							readonly="readonly"><br> <br></td>
					</tr>

					<tr>
						<td><label>Joining Date</label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.joining_date}"/>
							readonly="readonly"> <br>
						<br></td>
					</tr>
					<tr><td><label>Employee Type</label></td>
					<td><input type="text"
						placeholder=<c:out value="${viewEmployee.emp_type}"/>
						readonly="readonly"> <br>
					<br></td>
					</tr>
			
					<tr>
						<td><label>Employee Status</label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.emp_status}"/>
							readonly="readonly">
						<br>
						<br>
						</td>
					</tr>

					
					<tr>
						<td><label>Experience</label></td>
						<td><input type="text"
							placeholder=<c:out value="${viewEmployee.exp_level}"/>
							readonly="readonly"><br><br>
						</td>
					</tr>
				</table>
			</div>

		</div>
	</div>




</body>
</html>