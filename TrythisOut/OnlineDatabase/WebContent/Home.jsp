<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<% 	String message = (String)session.getAttribute("user1");
	if(message == null) {
		response.sendRedirect("LoginForm.jsp");
	}
%>
<%  String suc = null;
	suc = (String)request.getAttribute("user3"); %>
</head>
<body>
<center>

<h1><font color = 'green'>Welcome <%= message %></font></h1><br>
<%  if(suc != null) { %>
		<font color = 'red'><%= suc %></font>
<% } %>
	
<p><a href = "UpdatePassword.jsp">Update UR Password</a></p>
<p><a href = "ViewEmpDtlsReport">View Employee Records</a></p>

<p><a href = "RegEmpForm.jsp">Add Employee details</a></p>
<p><a href = "ViewEmpDtlsReport">Remove Employee Records</a></p>

</center>
</body>
</html>