<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Softtek Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body onload="myFunction()">


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">
					Softtek Management Application </a>
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
				<form action="update" method="post">

					<caption>
						<h2>Edit Employee</h2>
					</caption>

					<%-- <c:if test="${employee != null}">
					<input type="hidden" name="id"
						value="<c:out value='${employee.emp_id}' />" />
				</c:if>
				 --%>
					<fieldset class="form-group">
						<label>Employee Id</label> <input readonly="readonly" type="text"
							value="<c:out value="${employee.emp_id}"/>" class="form-control"
							name="emp_id" required="required">
					</fieldset>



					<fieldset class="form-group">
						<label>First Name</label> <input type="text" readonly="readonly"
							value="<c:out value='${employee.first_name}' />"
							class="form-control" name="first_name" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Last Name</label> <input type="text" readonly="readonly"
							value="<c:out value='${employee.last_name}' />"
							class="form-control" name="last_name">
					</fieldset>


					<fieldset class="form-group">
						<label>Gender</label> <br>
						<div
							style="display: flex; flex-direction: row-reverse;
							justify-content: space-evenly; width: 50%;"> <input type="radio"
								readonly="readonly" value="f" required
								class="form-check-input" name="gender"/>female <input style="left: 10%"
								type="radio" readonly="readonly"  value="m" required
								class="form-check-input" name="gender"/>Male
						</div>
					</fieldset>

					<fieldset class="form-group">
						<label>Address</label> <input type="text"
							value="<c:out value='${employee.address}' />"
							class="form-control" name="address">
					</fieldset>

					<fieldset class="form-group">
						<label>User email</label> <input readonly="readonly" type="text"
							value="<c:out value='${employee.email}' />" class="form-control"
							name="email">
					</fieldset>

					<fieldset class="form-group">
						<label>Date of birth</label> <input type="date"
							readonly="readonly"
							value="<c:out value='${employee.birth_date}' />"
							class="form-control" name="date_of_birth">
					</fieldset>

					<fieldset class="form-group">
						<label>Contact Number</label> <input type="text"
							value="<c:out value='${employee.contactno}' />"
							class="form-control" name="contactno">
					</fieldset>

					<fieldset class="form-group">
						<label>Joining Date</label> <input readonly="readonly" type="text"
							value="<c:out value='${employee.joining_date}' />"
							class="form-control" name="joining_date">
					</fieldset>

					<fieldset class="form-group">
						<label>Employee Type</label> <input readonly="readonly"
							type="text" value="<c:out value='${employee.emp_type}' />"
							class="form-control" name="emp_type">
					</fieldset>

					<fieldset class="form-group">
						<label>Employee Status</label> <input readonly="readonly"
							type="text" value="<c:out value="${employee.emp_status}" />"
							class="form-control" name="emp_status">
					</fieldset>

					<fieldset class="form-group">
						<label>Experience</label> <input type="text"
							value="<c:out value="${employee.exp_level}"/>"
							class="form-control" name="exp_level">
					</fieldset>

					<button type="submit" class="btn btn-success">Save details</button>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function myFunction() {
			var gen = document.getElementsByName('gender');
			for (i = 0; i < gen.length; i++) {
				if (gen[i].value == '${employee.gender}') {
					gen[i].setAttribute("checked", "checked");
				}
			}
		}
	</script>
</body>
</html>