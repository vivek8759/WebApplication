<%@page import="java.sql.ResultSet"%>
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
<h1><font color="red">User Details Report</font></h1>
<table border = "1">
<tr><th>Emp Id</th>
<th>Emp Name</th>
<th>Salary</th>
</tr>
<%		ResultSet rs = (ResultSet)request.getAttribute("UserRecords");
		if(rs != null) {

			do {%>
				<tr><td><%= rs.getString(1) %></td>
					<td><%= rs.getString(2) %></td>
					<td><%= rs.getString(3) %></td>
				</tr>

		<% } while(rs.next()); 
		}else{
		out.print("Nothing fetched");
		}%>
</table>
<br>
<form action="LOCS" method = "post">
<table>
<tr><td><input type = "submit" value = "Log Out"/></td></tr>
</table>
</form>
</center>
</body>
</html>