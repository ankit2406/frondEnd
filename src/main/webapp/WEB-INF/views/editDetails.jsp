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
            <form action="updateDetails">
            	<tr>
            		<td>User ID:</td>
            		<td><input type="text" value="${userDetail.getUser_id()}" disabled> </td>
            	</tr>
            	<tr>
            		<td>Name:</td>
            		<td><input type="text" name="name" value="${userDetail.getName()}"> </td>
               	</tr>
                <tr>
                	<td>Email:</td>
                	<td><input type="email" name="email" value="${userDetail.getEmail()}" required></td>
                </tr> 
                <tr>
                	<td>Contact:</td>
                	<td><input type="text" name="contact" value="${userDetail.getContact()}" required></td>
                </tr>   
                
                <tr>
                	<td></td>
                	<td><a href="updateDetail">Update</a></td>
                </tr>
				</form>
				</table>                     

</body>
</html>