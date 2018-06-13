<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h1>Welcome to the registration page for Apollo shoes </h1>

<form:form action="process-register" method= "POST" modelAttribute="customerkey">
	
	<label>User Name</label>
		<form:input type="text" id="userName" placeholder="User Name" path="userName"/>
		<form:errors path="userName"></form:errors><br>
	<label>Password</label>
		<form:input type="text" id="password" placeholder="Password" path="password" />
		<form:errors path="password"/><br>
	<label>Email</label>
		<form:input type="text" id="email" name="email" path="email" placeholder="Email"/>
		<form:errors path="email" /><br>
	<label>Register</label>
		<input type="submit" id="register" name="register" value="register">		
</form:form>
</body>
</html>