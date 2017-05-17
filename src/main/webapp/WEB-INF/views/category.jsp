<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Category</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>



	<h2>Select Category</h2>


		
	<div id="ShowCategories">

		<table border="2">
			

			<c:forEach var="category" items="${categoryList}">

				<tr>
		
					
					

					<td><a href="select_category/${category.category_id}">
						${category.category_name} </a> 



				</tr>






			</c:forEach>


		</table>

	</div>


</body>
</html>
















