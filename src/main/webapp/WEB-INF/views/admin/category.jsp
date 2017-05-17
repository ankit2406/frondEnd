<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Categories</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>


	<h2>Manage Categories</h2>

	<div id="CreateCategory">

		<form action="manage_category_add">

			<input type="text" name="name" placeholder="Category Name"> <input
				type="submit" value="Create Category">
		</form>

	</div>


	<div id="UpdateCategory">

		<form action="manage_category_update" method="post">

			<input type="text" name="id" value="${selectedCategory.category_id}">
			<input type="text" name="name" value="${selectedCategory.category_name}"
				required="required"> <input type="submit"
				value="Update Category">
		</form>

	</div>

	<h2>Delete / Update the Categories</h2>
	<div id="ShowCategories">

		<table border="2">
			<thead>
				<tr>
					<td>Category ID</td>
					<td>Category Name</td>
					<td>Action</td>
				</tr>
			</thead>

			<c:forEach var="category" items="${categoryList}">

				<tr>
					<td>${category.category_id}</td>
					<td>${category.category_name}</td>


					<td><a href="manage_category_delete/${category.category_id}">
							<font color="red">Delete </font> |
					</a><a href="manage_category_edit/${category.category_id}"> Edit
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>