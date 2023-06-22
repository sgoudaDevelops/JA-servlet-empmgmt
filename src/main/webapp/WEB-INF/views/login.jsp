<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to softtek employe Management</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
body {
	background:
		url('https://images.hdqwalls.com/wallpapers/forest-waterfall-minimal-4k-py.jpfg');
}
</style>
</head>


<body>


	<%--  <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/WEB-INF/views/login.jsp");
    }
    %>  --%>


	<div class="container col-md-4" style="margin-top: 7%">
		<div class="card">
			<div class="card-body">
				<form action="loginValidation" method="post">
					<h2>
						<i class="fa-solid fa-user"></i> Login
					</h2>
					<hr>
					<fieldset class="form-group">
						<label>Email</label> <input required="required" type="email"
							class="form-control" name="email">
					</fieldset>



					<fieldset class="form-group">
						<label>Password</label> <input required="required" type="password"
							class="form-control" name="password">
					</fieldset>



					<br>
					<button type="submit" class="btn btn-primary">
						<i class="fa-solid fa-down-to-bracket"></i> Login
					</button>

					<div class="text-center">
						<p>
							Not a member? <a href="#!">Register</a>
						</p>
						<p>or sign up with:</p>
						<button type="button" class="btn btn-link btn-floating mx-1">
							<i class="fab fa-facebook-f"></i>
						</button>



						<button type="button" class="btn btn-link btn-floating mx-1">
							<i class="fab fa-google"></i>
						</button>



						<button type="button" class="btn btn-link btn-floating mx-1">
							<i class="fab fa-twitter"></i>
						</button>



						<button type="button" class="btn btn-link btn-floating mx-1">
							<i class="fab fa-github"></i>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>