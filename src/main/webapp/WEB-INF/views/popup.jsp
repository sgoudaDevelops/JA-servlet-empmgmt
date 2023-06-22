<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Probation to Confirm</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>

	<c:choose>
		<c:when test="${message == 0 }">
			<div class="alert alert-danger"
				style="width: 240px; height: 100px; margin: auto; top: 10px"
				role="alert">
				<h4 class="alert-heading" style="margin: auto;">No records
					Founds!</h4>
				<hr>
				<p style="margin: auto;">Please check tommorow</p>
			</div>
		</c:when>
		<c:when test="${message > 0}">
			<div class="alert alert-success"
				style="width: 240px; height: 100px; margin: auto; top: 10px"
				role="alert">
				<h4 class="alert-heading" style="margin: auto;">Comfirmed!</h4>
				<hr>
				<p style="margin: auto;">${message} records Updated</p>
			</div>
		</c:when>
	</c:choose>

</body>
</html>