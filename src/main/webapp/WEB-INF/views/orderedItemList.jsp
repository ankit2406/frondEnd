<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<table class="table table-hover">
			<thead>
				<tr>
					<th>ORDERED ITEM</th>
					<th>QUANTITY</th>
					<th>TOTAL PRICE</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${orderedItems}">

				<tbody>
					<tr>
						<td>${item.product.product_Name}</td>
						<td>${item.getSell_quantity()}</td>
						<td>${item.total_price}</td>
						</tr>
				</tbody>
			</c:forEach>
			<tr>
			<td></td>
			<td><b>Shipping</b></td>
			<td>${shipping}</td>
			
			</tr>
			<tr>
			<td></td>
			<td><b>Grand Total</b></td>
			<td>${gTotal+shipping}</td>
			
			</tr>
		</table>
	</div>
				
	
</body>
</html>