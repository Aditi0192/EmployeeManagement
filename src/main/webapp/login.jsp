<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>  
 
<s:form action="loginprocess">  
<s:textfield name="uname" label="Name"></s:textfield>  
<s:password name="upass" label="Password"></s:password>  
<s:submit value="login"></s:submit>  
</s:form>  

</body>
</html>