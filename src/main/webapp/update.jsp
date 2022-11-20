<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Update</title>
</head>
<body>
	<h2>Struts 2 Create, Read, Update and Delete (CRUD) Example using JDBC</h2>
	<form action=updatedetails method="post">
		<pre>
<b>Name:         </b><input type="text" name="uname" value='<s:property value="uname"/>'>
		
		
<b>Email:        </b><input type="email"  name="uemail" value='<s:property value="uemail"/>'>
		            <input type="hidden" name="uemailhidden" value='<s:property value="uemail"/>'>
		
<b>Password:     </b><input type="password" name="upass" value='<s:property value="upass"/>'>


<b>Salary:     </b><input type="text" name="sal" value='<s:property value="sal"/>'>
		
		
<b>Designation:  </b><input type="text" name="udeg" value='<s:property value="udeg"/>'>
		
		<button name="submitType" value="update" type="submit">Update</button>
		</pre>
		
		<a href="report"><button class="button-report" type="button">Report</button></a>
		
		<a href ="register.jsp">click here for register page </a>
	</form>
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>