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

<h2>  Manage Users  </h2>

	
	
	<h2> Delete / Update the Suppliers  </h2>
	<div id="ShowSuppliers">
	
		<table border="2">
		<thead>
		<tr>
		<td> User ID</td>
		<td> Name</td>
		<td> Role </td>
		<td>  Enabled  </td>
		<td>  Action  </td>
		</tr>
		</thead>
		
	<c:forEach var="user" items="${userList}">
	
	<tr>  
	 <td> ${user.user_id} </td>
	  <td> ${user.name} </td>
	   <td> ${user.role} </td>
	   <td> ${user.enabled} </td>
	   
	   <td> <a href="manage_user_delete/${user.user_id}"> Delete | </a>   
	   <a href=""> Update  </a>    </td>
	
	</tr>

	</c:forEach>
	
	</table>
	
	</div>
	
</body>
</html>