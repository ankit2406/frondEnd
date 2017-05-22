<!DOCTYPE html>
<html lang="en">
<head>
  <title>Header Menu</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <ul class="nav nav-pills">

  
    <li class="active"><a href="/">Home</a></li>
    <li><a href="categoryPage">Supplements</a></li>
    <li><a href="#">About Us</a></li>
    <li><a href="#">Contact Us</a></li>
    
	<c:if test="${userId!=null}">

	    <li><a href="myCart">Cart</a></li>
	

	</c:if>
    
  </ul>
</div>
</body>
</html>
