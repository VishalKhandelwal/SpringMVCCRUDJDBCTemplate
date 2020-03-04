<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
  width:40px;
}
th {
  background-color: #4CAF50;
  color: white;
}

.tablePerson a{
text-decoration: none;
}

.tablePerson a:hover
{
 text-decoration: underline; 
}
   h5{
    font-family:helvetica;
    font-size:18px;
    font-weight:bold;
    color:#b00c0c;
    
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
    
      <li><a href="<c:url value='/persons'/>">View Employees</a></li>
      <li><p class="active">View Leaves</p></li>
      
      <li><a href="<c:url value='/viewEmpProfileById'/>">Find Employee</a></li>
      <li><a href="<c:url value='/homepage'/>">Logout</a></li>
    </ul>
  </div>
  
  <div class="column middle">
    <h5>Pending Leave Applications</h5>


<c:if test="${!empty listPersonsLeaves}">
	<table class="tablePerson">
	<tr>
									<th>Leave ID</th>
				
					<th>Emp ID</th>
	
 	<th>Leave Type</th>
		<th>Full Name</th>
		<th>Leave Start</th>
		<th>Leave End</th>
		<th>Days</th>
<!-- 		<th width="150">Email</th>
 -->		
		<th width="200">Reason</th>
      	<th>Approve</th>
         <th>Reject</th>
        
		
	</tr>
	<c:forEach items="${listPersonsLeaves}" var="personLeave">
		<tr>
				 				   <td>${personLeave.lid}</td>
				 
				   <td>${personLeave.eid}</td>
		
 			<td>${personLeave.leave_type}</td>
			<td>${personLeave.fullname}</td>
			<td>${personLeave.leave_start}</td>
			<td>${personLeave.leave_end}</td>
			<td>${personLeave.days}</td>
<%-- 			<td>${personLeave.email}</td>
 --%>			
			<td width="200">${personLeave.reason}</td>
	    	<td><a href="<c:url value='/leaveApprove/${personLeave.lid}' />" ><span style='font-size:20px; color:green;'>&#10004;</span>
	    	</a></td>
	    	<td><a href="<c:url value='/leaveReject/${personLeave.lid}' />" ><span style='font-size:20px; color:red;'>&#10008;</span>
	    	</a></td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>
  </div>
  
  </div>
  
  
</body>
</html>