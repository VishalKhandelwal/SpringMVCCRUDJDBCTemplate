<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</style>
</head>
<body>
<div class="row">
  <div class="column side">
    <ul>
      <li><a href="persons">View Employees</a></li>
      <li><a href="leaves">View Leaves</a></li>
      <li><a href="viewEmpProfileById">Find Employee</a></li>
      <li><a href="homepage">Logout</a></li>
    </ul>
  </div>
  
  <div class="column middle">
    <h2>Main Content</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque ultricies, eget elementum magna tristique. Quisque vehicula, risus eget aliquam placerat, purus leo tincidunt eros, eget luctus quam orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque ultricies, eget elementum magna tristique. Quisque vehicula, risus eget aliquam placerat, purus leo tincidunt eros, eget luctus quam orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
  </div>
  
  </div>
  
  
</body>
</html>