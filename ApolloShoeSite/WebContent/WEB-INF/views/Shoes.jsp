<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "apollo.model.*" %>
     <%@ page import = "apollo.dao.*" %>
     <%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "javax.servlet.http.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Shoes of the Gods</title>
</head>
<% Customer customer = (Customer) session.getAttribute("customerkey");  %>


<body>
<h1> The greatest Shoes in history</h1>
<nav>
<a href =""> Home</a>
<a href = "Customer"> Customer Page</a>
<a href="About"> About Us</a>
</nav>

<label> Shoes </label>
<form action=""></form>
<table>
<tr>
<th>Shoe Name </th>
<th>Shoe Size </th>
<th>Shoe Price </th>
<th>Gender </th>
<th>Quantity</th>
<th> </th>
</tr>

<%
	ShoesDAO shoeDAO = new ShoesDAO();

	
 	List<Shoes> listOfShoes = new ArrayList<Shoes> ();
 	listOfShoes = shoeDAO.getAllShoes();
	for(Shoes s : listOfShoes){
		out.write("<tr>");
		out.write("<td>"+s.getShoeName() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"</td>");
		out.write("<td>"+s.getShoeSize() + "</td>");
		out.write("<td>"+s.getPrice()  + "</td>");
		out.write("<td>"+s.getGender() + "</td>");
		out.write("<td><form action = 'Quantity'><select name= 'orderQuantity'>" +
		"<option value ='Zero'>0</option>"+
		"<option value ='One'>1</option>"+
		" <option value ='Two'>2</option> "+
		"<option value ='Three'>3</option>"+
		"<option value ='four'>4</option>"+
		" <option value ='Five'>5</option> "+
		"<option value ='Six'>6</option>"+
		" <option value ='Seven'>7</option> "+
		"<option value ='Eight'>8</option>"+
		"<option value ='Nine'>9</option>"+
		" <option value ='Ten'>10</option> "+
		"<input type= 'submit' name='order'  id='order' value= 'submit'>"+
				"</td>" );
		out.print("</tr>");
	} 	


%>
</table>

</body>
</html>