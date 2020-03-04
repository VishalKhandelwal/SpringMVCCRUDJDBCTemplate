<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-color: #3d3b3b;
	background-repeat: no-repeat;
}

.center {
	margin-left: 520px;
	margin-top: 150px;
}

.text {
	height: 40px;
	width: 250px;
	margin-bottom: 20px;
	border-radius: 2px;
	border: 2px solid white;
	font-size: 16px;
	font-family: helvetica;
	padding-left: 10px;
}

input[type="submit"] {
	height: 40px;
	width: 250px;
	margin-bottom: 20px;
	border-radius: 2px;
	border: 2px solid #18963a;
	font-size: 16px;
	font-family: helvetica;
	background-color: #18963a;
	color: white;
	text-align: center;
}

#header {
	font-size: 22px;
	font-family: helvetica;
	color: white;
	padding-left: 0px;
}
</style>

</head>
<body>

	<div class="center">

		<div>

			<p id="header">
				<b>Employee Management</b>
			



		</div>
				<div id="formEmp">
			<form action="login_emp" method="post">
				<input class="text email" type="email" name="email"
					placeholder="Enter Email" required="required"><br />
				<br /> <input class="text password" type="password" name="password"
					placeholder="Enter Password" required="required"><br />
				<br /> <input type="submit" value="Login">
			</form>
		</div>
		<h2 style="color: red;">Wrong Username or password error!!!</h2>
	</div>
	

</body>
</html>