<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
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
</style>
</head>
<body>
	<div class="row">
		<div class="column side">
			<ul>
				<li><a href="<c:url value='/viewMyProfile/${person.id }'/>">View My Profile</a></li>
				<li><p class="active">Apply For Leave</p></li>
				<li><a href="<c:url value='/homepage'/>">Logout</a></li>
			</ul>
		</div>

		<div class="column middle">
		<c:url var="leaveapplyAction" value="/leave_applied"></c:url>
			<form:form action="${leaveapplyAction }" method="post"
				modelAttribute="personLeave">

				<table>

					<tr>
						<td>Emp ID :</td>
						<td><form:input path="eid" value="${person.id }" disabled="true" />
						<form:hidden path="eid" value="${person.id }"/></td>
					</tr>
					<tr>
						<td>Leave Type:</td>
						<td><form:select path="leave_type">
								<form:option value="0">--Select--</form:option>
								<form:option value="Casual Leave">Casual Leave</form:option>
								<form:option value="Medical Leave">Medical Leave</form:option>
								<form:option value="Maternity Leave">Maternity Leave</form:option>
								<form:option value="Vacation Leave">Vacation Leave</form:option>
							</form:select></td>
					</tr>
					<tr>
						<td>Enter Full Name :</td>
						<td><form:input path="fullname" value="${person.name}"/></td>
					</tr>
					<tr>
						<td>Leave Start Date (DD/MM/YYYY) :</td>
						<td><form:input path="leave_start" /></td>
					</tr>
					<tr>
						<td>Leave End Date (DD/MM/YYYY) :</td>
						<td><form:input path="leave_end" /></td>
					</tr>
					<tr>
						<td>Total Days :</td>
						<td><form:input path="days" /></td>
					</tr>
					<tr>
						<td>Your Email :</td>
						<td><form:input path="email" value="${person.email}"/></td>
					</tr>
					<tr>
						<td>Reason :</td>
						<td><form:textarea path="reason" rows="5" cols="50" /></td>
					</tr>
				</table>

				<input type="submit" value="Apply for Leave">
			</form:form>
		</div>

	</div>


</body>
</html>