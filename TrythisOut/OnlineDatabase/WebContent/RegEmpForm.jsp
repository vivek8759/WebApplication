<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Form</title>
</head>
<body>
<center>
<form name = 'regForm' action = 'RCS' method = 'post'>
<h2>Enter Registration Details</h2><br>
<table>
<tr>
<td>Enter Employee id: </td>
<td><input type = 'text' name = 'id' placeholder = 'Enter id'>
</td>
</tr>
<tr>
<td>Enter Employee Name: </td>
<td><input type = 'text' name = 'name' placeholder = 'Enter name'>
</td>
</tr>
<tr>
<tr>
<td>Enter Employee Salary: </td>
<td><input type = 'text' name = 'sal' placeholder = 'Enter amount'>
</td>
</tr>
<tr>
<td><input type = 'submit' name = 'b1' value = 'Register'></td>
<td><input type = 'reset' name = 'b1' value = 'Clear'>
</td>
</tr>
</table>
</form>
</center>
</body>
</html>