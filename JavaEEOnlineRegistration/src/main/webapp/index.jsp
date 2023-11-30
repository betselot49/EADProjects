<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>Registration Form</h2>

	<form action="register" method="post">
		Name: <input type="text" name="name"><br> Email: <input
			type="text" name="email"><br> Password: <input
			type="password" name="password"><br> <input
			type="submit" value="Register">
	</form>
</body>
</html>