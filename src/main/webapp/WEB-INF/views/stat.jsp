<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>statics</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a  class="navbar-brand">
					Employee Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Home</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container">
		<h2 class="text-center">
			Statistics <i class="fa-solid fa-chart-simple"></i>
		</h2>
		<hr>
		<h4>Gender</h4>
		<table class="table  table-bordered"
			style="border-radius: 10px">
			<thead>
				<tr class="table-primary">
					<th><i class="fa-solid fa-mars"></i> Male</th>
					<th><i class="fa-solid fa-venus"></i> Female</th>
					<th><i class="fa-solid fa-people-group"></i> Total</th>
				</tr>
			</thead>
			<tbody>
				<!--   for (Todo todo: todos) {  -->
				<tr>

					<td><c:out value="${genderStat['male_count']}" /></td>
					<td><c:out value="${genderStat['female_count']}" /></td>
					<td><c:out value="${genderStat['total_count']}" /></td>

				</tr>
			</tbody>
		</table>
		<br>
		<h4>Employee Type</h4>
		<table class="table  table-bordered "
			style="border-radius: 10px">
			<thead>
				<tr class="table-warning">
					<th><i class="fa-solid fa-check-to-slot"></i> Full Time
						Employee</th>
					<th><i class="fa-solid fa-pen-to-square"></i> Contract</th>
					<th><i class="fa-solid fa-people-group"></i> Total</th>
				</tr>
			</thead>
			<tbody>
				<!--   for (Todo todo: todos) {  -->
				<tr>
					<td><c:out value="${typeStat['fte_count']}" /></td>
					<td><c:out value="${typeStat['con_count']}" /></td>
					<td><c:out value="${typeStat['total_count']}" /></td>
				</tr>
			</tbody>
		</table>
		<br>
		<h4>Employee Status</h4>
		<table class="table table-bordered " style="border-radius: 10px">
			<thead>
				<tr class="table-danger">
					<th><i class="fa-solid fa-check-double"></i> Permanent</th>
					<th><i class="fa-solid fa-spinner"></i> Probation</th>
					<th><i class="fa-solid fa-people-group"></i> Total</th>
				</tr>
			</thead>
			<tbody>
				<!--   for (Todo todo: todos) {  -->
				<tr>
					<td><c:out value="${statusStat['p_count']}" /></td>
					<td><c:out value="${statusStat['c_count']}" /></td>
					<td><c:out value="${statusStat['total_count']}" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>


</html>