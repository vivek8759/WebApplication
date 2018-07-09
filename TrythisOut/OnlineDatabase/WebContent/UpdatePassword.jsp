<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Password Page</title>

</head>
<body>
<center>
<FORM ACTION="ChangePassword" METHOD="post">
  
<div id="login_box">
  <div id="login_header">
        Update Password Form
  </div>
  <div class="label">New Password:</div>
    <div class="control"><input type="password" name="newPwd" id="Password"/></div>

    <div class="label">Confirm New Password:</div>
    <div class="control"><input type="password" name="conNewPwd" id="Password"/></div>
    <div style="clear:both;height:0px;"></div>

    <div id="msgbox"></div>
  </div>

  <div id="login_footer">
  
     <label>
    <input type="submit" name = "b1" value = "Update" />
    <input type = "reset" name = "b1" value = "Clear">
    </label>
     </div>
</FORM>

</center>
</body>
</html>