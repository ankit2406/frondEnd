<!DOCTYPE html>
<html lang="en">
<head>
  <title>Header Menu</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/menu.css">
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <ul class="nav nav-pills">

  
    <li class="active"><a href="welcomePage">Home</a></li>
    <li><a href="categoryPage">Supplements</a></li>
    <li><a href="aboutUs">About Us</a></li>
    <li><a href="contactUs">Contact Us</a></li>
    
	<c:if test="${userId!=null}">
	
	    <li><a href="myCart">Cart</a></li>
		<li><div class="dropdown">
			<button class="dropbtn">My Account</button>
  			<div class="dropdown-content">
    		<a href="account_details/${sessionScope.userId}">Account Details</a>
    		<a href="orderHistory">Order History</a>
    		<a href="#">Change Password</a>
    		<a href="#">Sign Out</a>
  			</div>
			</div> 
		</li>

	</c:if>
	
    <div class="dropdown">
			<button class="dropbtn">Supplements</button>
  			<div class="dropdown-content">
  			
  			<c:forEach var="category" items="${categoryList}">
  				<form action="select_category">
  					<input type="hidden" name="category_id" value="${category.category_id}">
  				
  					<input type="submit" class="btn btn-primary" value="${category.category_name}" >
  				
  				</form>
  			</c:forEach>
    		</div>
			</div> 
		</li>	
 
  </ul>
</div>

</body>
</html>
