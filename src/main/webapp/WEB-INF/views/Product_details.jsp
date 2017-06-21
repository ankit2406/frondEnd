<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details </title>
</head>
<body>
	
	<h3>Product Details</h3>
	
	ID: ${selectedProduct.product_Id} <br>
	Name:${selectedProduct.product_Name}<br>
	Brand: ${selectedProduct.getBrand()}<br>
	Description:${selectedProduct.product_Description}<br>
	Price:${selectedProduct.getPrice() }<br>
	
	<a href="Cart_add/${selectedProduct.product_Id}">Add to cart</a><br>
	

</body>
</html>