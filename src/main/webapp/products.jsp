<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>product</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>
	<h3>Products </h3>
	<c:forEach var="product" items="${categorisedPlist}">
	ID: ${product.product_Id} <br>
	Name:<a href="product_details/${product.product_Id}"> ${product.product_Name} </a><br>
	Brand:${product.getBrand()}<br>
	Price:${product.getPrice()}<br>
	Description:${product.product_Description}<br>
	
	<a href="Cart_add/${product.product_Id}">Add to cart</a>
	<br><br>
	</c:forEach>
</body>
</html>