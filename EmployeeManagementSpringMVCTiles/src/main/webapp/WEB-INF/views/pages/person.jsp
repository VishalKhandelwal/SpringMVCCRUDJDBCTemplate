<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  
<%@ page session="false" %>
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
  overflow: auto;
 }

/* Style the list inside the menu */
.side ul {
  list-style-type: none;
  padding: 0;
  
}

.side li{
margin-top: 20px; 
}

/* Style the topnav links */
.side a {    
  font-size:18px;
    font-family:helvetica;
    color:white;
    text-decoration:none;  
    
}

/* Change color on hover */
.side a:hover {
  background-color: #ddd;
  color: black;
  background: #ddd;
}

.row{
margin-top: -9px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

table {
  border-collapse: collapse;
  width: 100%;
}
th, td {
  text-align: left;
  padding: 8px;
  border-bottom: 1px solid #ddd;
}
th {
  background-color: #4CAF50;
  color: white;
}
tr:hover {background-color: #f5f5f5;}

.tablePerson a {    
  font-size:18px;
    font-family:helvetica;
    text-decoration:none;  
    
}

/* Change color on hover */
.tablePerson a:hover {
 background-color: #4CAF50;
  color: white;
  display: inline-block;
  /* background: #673ab7; */
}

#news a:hover {
background-color: #212121;
  color: white;
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
      <li><p class="active">View Employees</p></li>
      <li><a href="<c:url value='/leaves'/>">View Leaves</a></li>
      <li><a href="<c:url value='/viewEmpProfileById'/>">Find Employee</a></li>
      <li><a href="<c:url value='/homepage'/>">Logout</a></li>
    </ul>
  </div>
  
  <div class="column middle">
    <div id="news" style="float:left;">
<a id="new" href="showAddForm" style="text-decoration: none;border: 1px solid #2196f3;border-radius: 5px;max-width: 20px;">
<b style="padding: 10px;">Add Employee</b></a>
</div><br><br>
<c:if test="${!empty listPersons}">
	<table class="tablePerson">
	<tr>
		<th>Emp ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>DOB</th>
		<th>Gender</th>
		<th>Address</th>
		<th>City</th>
		<th>Password</th>
		<th>Phone</th>
		<th>Edit</th>
		<th>Delete</th>
		<th>Mailing</th>
		
	</tr>
	<c:forEach items="${listPersons}" var="person">
		<tr>
			<td>${person.id}</td>
			<td>${person.name}</td>
			<td>${person.email}</td>
			<td>${person.dob}</td>
			<td>${person.gender}</td>
			<td>${person.address}</td>
			<td>${person.city}</td>
			<td>${person.password}</td>
			<td>${person.phone}</td>
			<td><a id="edit" href="<c:url value='/edit/${person.id}' />" ><b>Edit</b></a></td>
			<td><a id="remove" onclick="return ConfirmDelete()" href="<c:url value='/remove/${person.id}' />" ><b>Delete</b></a></td>
			<td><a id="mail" href="<c:url value='/mail/${person.id}' />" ><b>Send Mail</b></a></td>
		   
		</tr>
	</c:forEach>
	</table>
</c:if>


      </div>
  
  </div>
  
  <script>
function ConfirmDelete()
{
  var x = confirm("Are you sure you want to delete?");
  if (x)
      return true;
  else
    return false;
}
</script>
</body>
</html>