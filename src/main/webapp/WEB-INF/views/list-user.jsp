<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
tr {
	background-color: thistle;
}

th {
	background-color: black;
	color: white;
}

</style>
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a class="navbar-brand"> Softtek Employee Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
			<%-- <% response.setHeader("Cache-Control", "no-cache , no-store,  must-revalidate");
              response.setHeader("Pragma", "no-cache");
              response.setHeader("Refresh", "120;url=/SEMgmt/");
              response.setDateHeader("Expires", 0);

               if (session.getAttribute("email") == null)
                response.sendRedirect("login"); --%>
			<div style="position: absolute; top: 1; right: 1%;">
				<form action="logout">
					<button class="btn btn-danger" type="submit"
						onclick="logoutAlert()">
						</i> Logout
					</button>
					<%
					session.removeAttribute("user");
					session.invalidate();
					%>
				</form>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
				<!--<a href="<%=request.getContextPath()%>/pTOc"
					class="btn btn-success"> Prob 2 Conf</a>-->
				</a> <a href="<%=request.getContextPath()%>/"
					/pTOc"
					class="btn btn-success" onclick="openWin()"
					<i class="fa-solid fa-check"> </i>Probation -> Confirm </a> <a
					href="<%=request.getContextPath()%>/statics"
					class="btn btn-success"> Statistics</a>
				<div style="float: right;">
					<form action="list" method="post">
						<table>
							<tr>
								<td><input class="form-control sm-3"
									style="margin-left: 6%;" placeholder="Employee Name"
									type="search" name="searchName"></td>
								<td><input class="btn btn-dark" type="submit"
									value="Search"></td>
							</tr>
						</table>
					</form>
				</div>

				<%-- <div style="float: right; width: 200px; position: relative;"
					class="input-group input-group-unstyled">
					<input type="text" class="form-control" /> <span
						class="input-group-addon"> <i class="fa fa-search"
						style="position: absolute; right: 4%; bottom: 25%;"></i>
					</span>
				</div>
				&nbsp; <a style="float: right; color: white; margin-right: 10px;"
					href="<%=request.getContextPath()%>/new" class="btn btn-dark">
					Search Employee</a>
			</div>
 --%>

				<br>
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th>User Id</th>
							<th>Name of the Employee</th>
							<th>Email</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>

						<c:if test="${searchEmployee != null}">
							<c:forEach var="user" items="${searchEmployee}">
								<tr>
									<td><c:out value="${user.emp_id}" /></td>
									<td><c:out value="${user.first_name} ${user.last_name}" /></td>
									<td><c:out value="${user.email}" /></td>
									<td><a class="btn btn-warning"
										href="edit?emp_id=<c:out value='${user.emp_id}' />"><i
											class="fas fa-edit"></i>Edit</a> &nbsp; <a
										class="btn btn-warning"
										href="delete?emp_id=<c:out value='${user.emp_id}' />"><i
											class="fa fa-trash" aria-hidden="true"></i>Delete</a> &nbsp; <a
										class="btn btn-warning"
										href="view?emp_id=<c:out value='${user.emp_id}' />"><i
											class="fa fa-eye"></i>View</a></td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${searchEmployee == null}">
							<!--   for (Todo todo: todos) {  -->
							<c:forEach var="user" items="${listEmployee}">

								<tr>
									<td><c:out value="${user.emp_id}" /></td>
									<td><c:out value="${user.first_name} ${user.last_name}" /></td>
									<td><c:out value="${user.email}" /></td>
									<td><a class="btn btn-warning"
										href="edit?emp_id=<c:out value='${user.emp_id}' />"><i
											class="fas fa-edit"></i>Edit</a> &nbsp; <a
										class="btn btn-warning"
										href="delete?emp_id=<c:out value='${user.emp_id}' />"><i
											class="fa fa-trash" aria-hidden="true"></i>Delete</a> &nbsp; <a
										class="btn btn-warning"
										href="view?emp_id=<c:out value='${user.emp_id}' />"><i
											class="fa fa-eye"></i>View</a></td>
								</tr>
							</c:forEach>
						</c:if>

					</tbody>

				</table>
				<nav aria-label="Navigation for countries">
					<ul class="pagination">
						<c:if test="${currentPage gt 1}">
							<li class="page-item"><a class="page-link"
								href="list?currentPage=${currentPage-1}">Previous</a></li>
						</c:if>

						<c:forEach begin="1" end="${noOfPages}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<li class="page-item active"><a class="page-link">
											${i} <span class="sr-only">(current)</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="list?currentPage=${i}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${currentPage lt noOfPages}">
							<li class="page-item"><a class="page-link"
								href="list?currentPage=${currentPage+1}">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
		<script>
			function openWin() {
				const myWindow = window.open("popup", "",
						"width=250, height=100,top=250px,left=500px");
				//setTimeout(function() { myWindow.close() }, 3000);
				setTimeout(function() {
					myWindow.close();
				}, 5000);
				//setTimeout('myWindow.close()', 5000)
			}
			function logoutAlert() {
				var txt;
				if (confirm("Do you want to Logout")) {
				} else {
				}
			}
		</script>
</body>

</html>