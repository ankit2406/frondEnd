<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
   
    <ul class="nav navbar-nav">
    
    <c:forEach var="category" items="${categoryList}">
    
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.category_name}<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Mobile</a></li>
          <li><a href="#">TV</a></li>
          <li><a href="#">Refrigerator</a></li>
        </ul>
      </li>
      
    </c:forEach>
      
    </ul>
  </div>
</nav>
  


</body>
</html>
