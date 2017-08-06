<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">

<script src="js/jquery-1.11.3.min.js"></script>

<script src="js/bootstrap.min.js"></script>
<!-- Optional Bootstrap theme -->

<link rel="stylesheet" href="css/bootstrap-theme.min.css">
</head>
<body>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<center>
		<h2>Welcome to BeastNutrition</h2>
	</center>
	${message}
	<hr color="blue">


	<c:choose>
		<c:when test="${userId!=null}">
   	 		welcome <%=session.getAttribute("uname")%>
			<a href="manage_logout">Logout</a>

		</c:when>
		<c:otherwise>
			<a href="LoginPage"> Signin</a>
			<a href="RegistrationPage"> Signup</a> &nbsp; &nbsp; &nbsp;
	
   	 </c:otherwise>
	</c:choose>



	<jsp:include page="HeaderMenu.jsp"></jsp:include>


	<c:if test="${isAdmin=='true'}">

		<jsp:include page="admin/adminHome.jsp"></jsp:include>

	</c:if>

	<c:if test="${isAdminClickedCategories=='true'}">

		<jsp:include page="admin/category.jsp"></jsp:include>

	</c:if>

	<c:if test="${isAdminClickedUsers=='true'}">
		<jsp:include page="admin/users.jsp"></jsp:include>
		<br>
	</c:if>

	<c:if test="${isAdminClickedProducts=='true'}">
		<jsp:include page="admin/products.jsp"></jsp:include>
		<br>
	</c:if>

	<br>
	<c:if test="${isUserClickedLogin=='true'}">

		<jsp:include page="signin.jsp"></jsp:include>

	</c:if>


	<c:if test="${isUserClickedRegister=='true' }">
		<jsp:include page="Register.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedHelp=='true' }">
		<jsp:include page="Help.jsp"></jsp:include>

	</c:if>

	<c:if test="${isUserClickedCategory=='true' }">
		<jsp:include page="category.jsp"></jsp:include>

	</c:if>

	<c:if test="${isUserSelectedCategory=='true' }">
		<jsp:include page="products.jsp"></jsp:include>

	</c:if>

	<c:if test="${isUserClickedCart=='true' }">
		<jsp:include page="myCart.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${isProductDetails=='true' }">
		<jsp:include page="Product_details.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${isAboutUs=='true' }">
		<jsp:include page="about_us.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${isContactUs=='true' }">
		<jsp:include page="contact_us.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${isUserClickedCheckout=='true' }">
		<jsp:include page="shippingDetails.jsp"></jsp:include>

	</c:if>
</body>
</html>