<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
				
				${orderList.getTotal_price()}
				${orderList.getOrderedItemId()}
	
</body>
</html>