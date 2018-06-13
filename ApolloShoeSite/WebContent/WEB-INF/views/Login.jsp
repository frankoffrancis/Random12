<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form:form action="process-login" method= "POST" modelAttribute="customerkey" >
<h1>  Welcome to the login page of Apollo Shoes</h1>
	<h2> Please login to start your shopping experience</h2>
<label> Email</label>
	<form:input type="text" id="email" name="email" placeholder="Email" path="email"/>
	<form:errors path="email" /><br>
	<label>Password</label>
	<form:input type="text" id="password"  placeholder="Password" path="password"/>
	<form:errors path="password"/><br>
	<label>Login</label>
		<input type="submit" id="login" name="login" value="Login">
</form:form>
</body>
</html>