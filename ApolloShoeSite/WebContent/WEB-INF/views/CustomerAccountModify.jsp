<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change your Account details</title>
</head>

<body>
<%@page import ="apollo.model.Customer" %>
<%@page import="apollo.dao.CustomerDAO"%>
<%Customer cus = (Customer)session.getAttribute("customerkey");  %>
<h1>Change User's Information</h1>
	<form action="updatePassword" method="POST" >
		<div class="sub_field">
			<label>Old Password</label> 
			<input type="text" id="password" name="password" placeholder="Current Password Here" > 
		</div>
		<div class="sub_field">
			<label>New Password</label> <input type="text" id="newPassword"
				name="newPassword" placeholder="New Password Here" >
		</div>		<div class="sub_field">
			<label>Confirm New Password</label> <input type="confirmNewPass" id="confirmNewPass"
				name="confirmNewPass" placeholder="Confirm Password Here" >
		</div>
		<div class="btn">
			<input type="submit" name="submit" value="Change Info" />
		</div>
	</form>

</body>
</html>