<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdatePasswordFailure Page</title>
<% 	String message = (String)session.getAttribute("user1"); 
	if(message == null) {
		response.sendRedirect("LoginForm.jsp");
	}
%>
</head>
<body>
<center>
<h2><font color = "red">Fatal error, Try after some time</font></h2>
</center>
</body>
</html>