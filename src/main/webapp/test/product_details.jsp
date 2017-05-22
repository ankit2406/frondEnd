<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>eCommerce Product Detail</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
 
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/product_details.css">
</head>
<body>

	    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>	
	<div class="container">
		<div class="card">
		<h2>Product Details</h2>
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="https://img3.hkrtcdn.com/1817/prd_181602_c_xxl.jpg" /></div>
						  </div>
						
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">MuscleTech NitroTech whey gold</h3>
						
						<p class="product-description"><ul><li> Superior whey protein peptides for better musclebuilding</li>
    													<li>100% whey - no added active ingredients</li></ul>

</p>
						
						<h5 class="sizes">Brand:
							<span class="size" data-toggle="tooltip" title="small">Muscletech</span>
							
						</h5>
						<h5 class="colors">Category:
							<span class="color">Whey Protein</span>
						</h5>
						
						<h4 class="price"> Price: &nbsp; <span>$180</span></h4>
						<div class="action">
							<button class="add-to-cart btn btn-default" type="button">add to cart</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
