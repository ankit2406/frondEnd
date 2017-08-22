<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/product.css">

<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>
<div class="products-grid">
	<header>
		<h3 class="head text-center">Featured Products</h3>
	</header>
	
	
	<div class="container" style="margin-top:50px;">
	<div class="row">
		<c:forEach var="product" items="${HotList}">
	
    	<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
            <div class="col-item">
                <div class="post-img-content ">
                    <div class="absolute-aligned">
                         <img src="<%=request.getContextPath()%>/resources/img/${product.product_Name}.jpg" class="img-responsive" />
                    </div>
                    <span class="round-tag">-15%</span>
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-12">
                            <div class="post-name-text">
                            <h5> ${product.product_Name}</h5>
                             </div>
                            <div class="row">
                                 <div class="price col-md-12">
                                    <strong>Brand</strong><span class="pull-right">${product.getBrand()}</span>
                                </div>
                                <div class="price col-md-12">
                                    <strong>Price</strong><span class="pull-right price-text-color">&#8377; ${product.getPrice()}</span>
                                </div>
                             </div>   
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p></p>
                        <button id="add_d3af2e19a4e14c3029d5698e718dd210" class="btn btn-outline btn-primary btn-sm btn-block btnAddAction btn-primary " onclick="javascript:location.href='Cart_add/${product.product_Id}'" type="button">
                        <i class="fa fa-shopping-cart fa-fw"></i>Add</button>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
      
		
		

</body>
</html>
				
</body>
</html>