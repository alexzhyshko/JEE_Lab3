<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AMC</title>
</head>
<body>
	<h1>Login to Admin Management Console</h1>
	<c:set var="loginUrl" scope="page" value="/JEE_Lab3/admin" />
	<form method="post" action="${loginUrl}">
		<label for="username">Username:</label>
		<input type="text" id="username" name="username"><br>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password"><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>