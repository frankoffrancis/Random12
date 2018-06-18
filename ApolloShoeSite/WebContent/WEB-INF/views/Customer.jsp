<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri= "http://www.springframework.org/tags/form" prefix="form" %>
    <%@ page import = "apollo.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Page </title>
</head>
<% Customer customer = (Customer) session.getAttribute("customerkey");  %>
<body>
<h1> Welcome </h1>
<h2> Hello <%= customer.getEmail()  %> </h2>
<nav>
<a href="about"> About us</a>
<a href="Shoes"> Shoe</a>
</nav>
<a href="modify"> Change Account information </a>
</body>
</html>