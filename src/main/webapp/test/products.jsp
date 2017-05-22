<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>

	<h1>Manage Products</h1>

	<div id="CreateProduct">

		<form action="manage_product_add">

			<input type="text" name="name" placeholder="Product Name"> 
			<input type="text" name="brand"	placeholder="Product Brand"> 
			<input type="text" name="price"	placeholder="Product Price">			
			<input type="text" name="description" placeholder="Description"> 
			<input type="text" name="category_id" placeholder="Category ID" required="required">
			<input type="file" placeholder="Upload Image" name="file"/>  
				<input type="submit" value="Create Product">

		</form>

	</div>


	<div id="UpdateProduct">

		<form action="manage_product_update" method="post">

			<input type="text" name="id" value="${selectedProduct.product_Id}" placeholder="Product ID" required="required"> 
			<input type="text" name="name" value="${selectedProduct.product_Name}" placeholder="Product Name" required="required"> 
			<input type="text" name="brand" value="${selectedProduct.getBrand()}" placeholder="Product Brand" required="required"> 
			<input type="text" name="price" value="${selectedProduct.getPrice()}" placeholder="Product Price" required="required"> 
			<input type="text" name="description" value="${selectedProduct.product_Description}" placeholder="Description" required="required"> 
			<input type="text" name="category_id" value="${selectedProduct.getCategory().category_id}" placeholder="Category ID" required="required">			
								
			<input type="submit" value="Update Product">
		</form>

	</div>


	<h2>Delete / Update the Products</h2>
	<div id="ShowProducts">

		<table border="2">
			<thead>
				<tr>
					<td>Product ID</td>
					<td>Product Name</td>
					<td>Product Brand</td>
					<td>Product Price</td>
					<td>Product Description</td>
					<td>Product Category</td>
					<td colspan="2" align="center">Action</td>
				</tr>
			</thead>

			<c:forEach var="product" items="${productList}">

				<tr>
					<td>${product.product_Id}</td>
					<td>${product.product_Name}</td>
					<td>${product.getBrand()}</td>
					<td>${product.getPrice()}</td>
					<td>${product.product_Description}</td>
					<td>${product.getCategory().category_name}</td>

					<td><a href="manage_product_delete/${product.product_Id}">Delete</a></td>
					<td><a href="manage_product_edit/${product.product_Id}">Edit</a></td>


				</tr>

			</c:forEach>

		</table>

	</div>


</body>
</html>