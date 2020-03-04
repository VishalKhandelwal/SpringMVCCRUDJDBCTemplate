<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%-- <%@ page isELIgnored="false" %> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
<title><tiles:insertAttribute name="title" ignore="true" /></title>    
</head>    
<body style="margin: 0;background-color:#3d3b3b;background-repeat:no-repeat;">    
        <div style="text-align: center;padding-top: 1px;color:white;"><tiles:insertAttribute name="header" /></div>    
        <div style="background-color: white;"><tiles:insertAttribute name="body" /></div>    
        <div style="text-align: center;margin-top: -8px;color:white;"><tiles:insertAttribute name="footer" /></div>    
    
    
</body>    
</html>