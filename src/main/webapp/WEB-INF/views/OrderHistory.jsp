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
					<th>ORDER ID</th>
					<th>ORDER PLACED</th>
					<th>SHIP TO</th>
					<th>ORDER TOTAL</th>
					<th>ACTION</th>
				</tr>
			</thead>
			<c:forEach var="order" items="${orderList}">

				<tbody>
					<tr>
						<td>${order.order_id}</td>
						<td>${order.getOrderDate()}</td>
						<td>${order.getFname()}</td>
						<td>&#8377; &nbsp;${order.getOrderTotal()}</td>
						<td><form action="viewOrderedItems">
						<input type="hidden" name="order_id" value="${order.order_id}">
						<input type="submit" value="view">
						</form>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>



	<div class="container">

		<table class="table table-hover">
			<thead>
				<tr>
					<th>ORDERED ITEM</th>
					<th>QUANTITY</th>
					<th>TOTAL PRICE</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${OrderedItems}">

				<tbody>
					<tr>
						<td>${item.product.product_Name}</td>
						<td>${item.getProduct().product_Name}</td>
						<td>${item.getProduct().getProduct_Name()}</td>
						<td>${item.total_price}</td>
						</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>