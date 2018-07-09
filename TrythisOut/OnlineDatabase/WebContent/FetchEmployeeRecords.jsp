<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<% 	String message = (String)session.getAttribute("user1"); 
	if(message == null) {
		response.sendRedirect("LoginForm.jsp");
	}
%>
</head>
<body>
<center>
<a href = "ViewEmpDtlsReport">SHOW DETAILS</a>
<br>
<% String mess = (String)request.getAttribute("msg");
	if(mess != null) {%>
		<font color = "red"><%= mess %></font>
<%	} %>
</center>
</body>
</html>