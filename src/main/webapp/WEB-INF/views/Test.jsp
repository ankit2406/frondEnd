<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <spring:url value="/resources/css/main.css" var="mainCss" />
	<spring:url value="/resources/js/jquery.1.10.2.min.js" var="jqueryJs" />
	<spring:url value="/resources/js/main.js" var="mainJs" />

	<link href="${mainCss}" rel="stylesheet" />
    <script src="${jqueryJs}"></script>
    <script src="${mainJs}"></script>
  <title>Testing</title>
</head>
<body>
	
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">WebSiteName</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">Page 1</a></li>
			<li><a href="#">Page 2</a></li>
			<li><a href="#">Page 3</a></li>
		</ul>
	</div>
	</nav>

	<div class="container">
		<h3>Basic Navbar Example</h3>
		<p>A navigation bar is a navigation header that is placed at the
			top of the page.</p>
	</div>



   



    <form class="form-horizontal">

        <div class="form-group">

            <label for="inputEmail" class="control-label col-xs-2">Email</label>

            <div class="col-xs-10">

                <input type="email" class="form-control" id="inputEmail" placeholder="Email">

            </div>

        </div>

        <div class="form-group">

            <label for="inputPassword" class="control-label col-xs-2">Password</label>

            <div class="col-xs-10">

                <input type="password" class="form-control" id="inputPassword" placeholder="Password">

            </div>

        </div>

        <div class="form-group">

            <div class="col-xs-offset-2 col-xs-10">

                <div class="checkbox">

                    <label><input type="checkbox"> Remember me</label>

                </div>

            </div>

        </div>

        <div class="form-group">

            <div class="col-xs-offset-2 col-xs-10">

                <button type="submit" class="btn btn-primary">Login</button>

            </div>

        </div>

    </form>



</body>
</html>