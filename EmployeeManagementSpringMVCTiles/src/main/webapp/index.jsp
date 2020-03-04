<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
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
			</p>

		</div>
		<!-- <button id="btn" onclick="myFunction()">Admin Login</button> -->
		<div id="form">
			<form action="login_adm" method="post">
				<input class="text text" type="text" name="username"
					placeholder="Enter Username" required="required"><br />
				<br /> <input class="text password" type="password" name="password"
					placeholder="Enter Password" required="required"><br />
				<br /> <input type="submit" value="Login">
			</form>
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
		<a id="btn" onclick="myFunction()" style="color: blue;">Login as Admin</a>
	</div>
	
	
	<script>
    
  var x = document.getElementById("form");
  var y = document.getElementById("formEmp");
  if (x.style.display === "none") {
    x.style.display = "block";
    y.style.display = "none";
    document.getElementById("btn").innerHTML = "Login as Employee";
  } else {
    x.style.display = "none";
    y.style.display = "block";
    document.getElementById("btn").innerHTML = "Login as Admin";
  }

function myFunction() {
  var x = document.getElementById("form");
  var y = document.getElementById("formEmp");
  if (x.style.display === "none") {
    x.style.display = "block";
    y.style.display = "none";
    document.getElementById("btn").innerHTML = "Login as Employee";
  } else {
    x.style.display = "none";
    y.style.display = "block";
    document.getElementById("btn").innerHTML = "Login as Admin";
  }
}
  </script>
</body>
</html>