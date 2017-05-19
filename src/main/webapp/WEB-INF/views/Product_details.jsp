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
	
	ID: ${selectedProduct.product_id}
	Name:${selectedProduct.product_name}
	Brand: ${selectedProduct.brand}
	Description:${selectedProduct.product.product_description}
	Price:${selectedProduct.price }
	
	<a href="Cart_add/${selectedProduct.product_id}">Add to cart</a>
	

</body>
</html>