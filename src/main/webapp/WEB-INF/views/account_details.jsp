<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${message}
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
            	<tr>
            		<td>User ID:</td>
            		<td>${userDetail.getUser_id()}</td>
            	</tr>
            	<tr>
            		<td>Name:</td>
            		<td>${userDetail.getName()}</td>
               	</tr>
                <tr>
                	<td>Email:</td>
                	<td>${userDetail.getEmail()}</td>
                </tr> 
                <tr>
                	<td>Contact:</td>
                	<td>${userDetail.getContact()}</td>
                </tr>   
                
                <tr>
                	<td><a href="editDetails">Edit</a></td>
                	<td><a href="deactivate">Deactivate Account</a></td>
                </tr>
					                       

</body>
</html>