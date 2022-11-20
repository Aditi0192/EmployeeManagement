<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>  
<hr/>  
 
  
<br/>Welcome, <s:property value="uname"/>  
<br>
<a href ="report"> click here to view employees </a>

</body>
</html>