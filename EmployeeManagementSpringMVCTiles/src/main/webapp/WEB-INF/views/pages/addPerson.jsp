<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

/* body {
  margin: 0;
} */

/* Create three unequal columns that floats next to each other */
.column {
	float: left;
	height: 524px;
	padding: 10px;
}

/* Left and right column */
.column.side {
	width: 15%;
	background: #333;
}

/* Middle column */
.column.middle {
	width: 85%;
}

/* Style the list inside the menu */
.side ul {
	list-style-type: none;
	padding: 0;
}

.side li {
	margin-top: 20px;
}

/* Style the topnav links */
.side a {
	font-size: 18px;
	font-family: helvetica;
	color: white;
	text-decoration: none;
}

/* Change color on hover */
.side a:hover {
	background-color: #ddd;
	color: black;
	background: #ddd;
}

.row {
	margin-top: -9px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}
.active{
background-color: #9e9e9e;
color:white;
font-size: 20px;
font-family: sans-serif;
font-weight: bold;
font-style: italic;
}
.error {
	color: red;
}
</style>
</head>
<body>
	<div class="row">
		<div class="column side">
			<ul>
				<li><p class="active">View Employees</p></li>
      <li><a href="<c:url value='/leaves'/>">View Leaves</a></li>
      <li><a href="<c:url value='/viewEmpProfileById'/>">Find Employee</a></li>
      <li><a href="<c:url value='/homepage'/>">Logout</a></li>
			</ul>
		</div>

		<div class="column middle">
			<c:url var="addAction" value="/person/add"></c:url>

			<form:form action="${addAction}" modelAttribute="person" method="post">

				<table>
					<tr>
						<td>Enter Name:</td>
						<td><form:input path="name" /></td>
						<td><form:errors path="name" cssClass="error" /></td>
					</tr>
					<tr>
				<td>Enter Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
						<td>Enter DOB:</td>
						<td><form:input path="dob" required="true" placeholder="DOB (DD/MM/YYYY)" /></td>
						<td><form:errors path="dob" cssClass="error"/></td>
					</tr>
					<tr>
				<td>Gender:</td>
				<td><form:radiobutton path="gender" value="Male" label="Male" />
					<form:radiobutton path="gender" value="Female" label="Female" /></td>
				<td><form:errors path="gender" cssClass="error" /></td>

			</tr>
			<tr>
						<td>Enter Address:</td>
						<td><form:textarea path="address" required="true" placeholder="Address" /></td>
						<td><form:errors path="address" cssClass="error" /></td>
					</tr>
					<tr>
				<td>Select city:</td>
				<td><form:select path="city">
						<form:option value="0">--Select--</form:option>
						<form:option value="Banglore">Banglore</form:option>
						<form:option value="Hubli">Hubli</form:option>
						<form:option value="Davangere">Davangere</form:option>
						<form:option value="Mysore">Mysore</form:option>
						<form:option value="Belgaum">Belgaum</form:option>
						<form:option value="Tumkur">Tumkur</form:option>
						<form:option value="Chitradurga">Chitradurga</form:option>
						<form:option value="Jaipur">Jaipur</form:option>
					</form:select></td>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
				<tr>
				<td>Enter Phone No:</td>
				<td><form:input path="phone"/></td>
				<td><form:errors path="phone" cssClass="error"/></td>

			</tr>	
					
					
					<tr>
						<td colspan="2"><input id="new" type="submit"
							value="Add Employee" /> <input id="new"
							type="reset" value="Reset Data"/></td>

					</tr>

				</table>

			</form:form>
		</div>

	</div>


</body>
</html>