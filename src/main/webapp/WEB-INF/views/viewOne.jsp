<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Softtek Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<h1><%=request.getContextPath()%>("emp_id")</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>User Id</th>
				<th>Name of the Employe</th>
				<th>Email</th>
				<th>birth Date</th>
				<th>gender</th>
				<th>joining date</th>
				<th>emp type</th>
				<th>emp status</th>
				<th>contact number</th>
				<th>exp level</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!--   for (Todo todo: todos) {  -->
			
     <!--   <c:forEach var="user" items="${user}"> -->
	
				<tr>
					<td><c:out value="${user.emp_id}" /></td>
					<td><c:out value="${user.first_name} ${user.last_name}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.birth_date}" /></td>
					<td><c:out value="${user.gender}" /></td>
					<td><c:out value="${user.joining_date }" /></td>
					<td><c:out value="${user.emp_type}" /></td>
					<td><c:out value="${user.emp_status}" /></td>
					<td><c:out value="${user.contactno}" /></td>
					<td><c:out value="${user.exp_level}" /></td>
					

					 <td><a href="edit?emp_id=<c:out value='${user.emp_id}' />">Edit</a>
						&nbsp; <a href="delete?emp_id=<c:out value='${user.emp_id}' />">Delete</a>
						&nbsp; <a href="view?emp_id=<c:out value='${user.emp_id}' />">View</a>
					</td>
				</tr>
			<!--	</c:forEach> -->
		
			
		</tbody>

	</table>

</body>
</html>