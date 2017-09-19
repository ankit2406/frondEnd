<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="security"
 uri="http://www.springframework.org/security/tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>signin /signup</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">

	<script src="js/jquery-1.11.3.min.js"></script>

    <script src="js/bootstrap.min.js"></script>
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css">
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/login.js"></script>

	    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>


<c:url value="/j_spring_security_check" var="login"></c:url>
 <form class="form-horizontal" action="${login }" method="post">
  <div class="form-group">
   <label class="control-label col-sm-2" for="email">Email:</label>
   <div class="col-xs-3">
    <input type="text" class="form-control" id="email"
     placeholder="Enter email" name="j_username">
          
   </div>
  </div>
  <div class="form-group">
   <label class="control-label col-sm-2" for="pwd">Password:</label>
   <div class="col-xs-3">
    <input type="password" class="form-control" id="pwd"
     placeholder="Enter password" name="j_password">
   </div>
  </div>
    <div class="form-group">       
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Login</button>
      </div>
    </div>
  </form>
  </div>
  </div>
</body>
</html>