<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Login</title>
</head>
<body>


	<form class="form-horizontal" action="login">

		<div class="form-group">

			<label for="inputEmail" class="control-label col-xs-2">Email</label>

			<div class="col-xs-5">

				<input type="email" class="form-control" name="email" id="inputEmail"
					placeholder="Email">

			</div>

		</div>

		<div class="form-group">

			<label for="inputPassword" class="control-label col-xs-2">Password</label>

			<div class="col-xs-5">

				<input type="password" name="password" class="form-control" id="inputPassword"
					placeholder="Password">

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