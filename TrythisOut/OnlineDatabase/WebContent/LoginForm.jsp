<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.container{
background-color:yellow;
width:100%;
height:400px;
position:absolute;
top:20%;

}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="bootstrap.css" rel="stylesheet">
<link href="bootstrap.min.css" rel="stylesheet">
<%  String message = null;
	message = (String)request.getAttribute("user2"); %>
</head>
<body >
<%  if(message != null) { %>
		<font color = 'red'><%= message %></font>
<%	} %>
<div class="container-fluid">
<div class="container text-center">
<h2 class="page-header">Enter Login Credentials</h2>
<form name = 'loginForm' action = 'LCS' method = 'post'>
	<div class="form-group" style="padding:10px">
			<div class="col-sm-12 col-xs-12 col-md-offset-4 col-md-8 text-left">
				<label class="control-label  text-left required" style="text-align:left;display:block">Email</label>
				<input type="text" name="emailId" class="input-lg" style="width:60%" placeholder = 'Enter id' required>
			</div>
		</div>
		
		<div class="form-group contact-us-form" style="padding:10px">
			<div class="col-sm-12 col-xs-12 col-md-offset-4 col-md-8 text-left">
				<label class="control-label  text-left required" style="text-align:left;display:block">Password</label>
				<input type="password" name="pwd" class="input-lg" style="width:60%" placeholder = 'Enter password' required>
			</div>
		</div>
<input class="btn-success btn-lg" style="margin-top:5px;border-radius:0px" type = 'submit' name = 'b1' value = 'Login'>
<input class="btn-danger btn-lg" style="margin-top:5px;border-radius:0px" type = 'reset' name = 'b1' value = 'Clear'>
</form>
</div>
</div>
</body>
</html>