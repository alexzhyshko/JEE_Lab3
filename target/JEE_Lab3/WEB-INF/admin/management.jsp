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
	<c:set var="submitUrlCurrency" scope="page"
		value="/JEE_Lab3/admin/management/currency" />
	<c:set var="submitUrlRate" scope="page"
		value="/JEE_Lab3/admin/management/rate" />
	<h1>Welcome to Admin Management Console</h1>
	<h3>Create a currency</h3>
	<form method="post" action="${submitUrlCurrency}">
		<tr>
			<td><input type="text" name="code"></td>
			<td><input type="submit" name="action" value="create">✅</td>
		</tr>
	</form>
	<br />
	<h3>Available currencies</h3>
	<table>
		<c:forEach items="${requestScope.currencies}" var="currency">
			<form method="post" action="${submitUrlCurrency}">
				<tr>
					<td><input type="hidden" name="id" value="${currency.id}"></td>
					<td><input type="text" name="code" value="${currency.code}"></td>
					<td><input type="submit" name="action" value="edit">✅</td>
					<td><input type="submit" name="action" value="delete">❌</td>
				</tr>
			</form>
		</c:forEach>
	</table>
	<br />
	<h3>Add a rate:</h3>
	<form method="post" action="${submitUrlRate}">
		<tr>
			<td><input type="number" name="rate" step="0.1"></td>
			<td><input type="date" name="date" min="${requestScope.todayDate}" value="${requestScope.todayDate}"></td>
			<td><select name="currency">
					<c:forEach items="${requestScope.currencies}" var="currency">
						<option value="${currency.code}">${currency.code}</option>
					</c:forEach>
			</select></td>
			
			<td><input type="submit" name="action" value="create">✅</td>
		</tr>
	</form>

</body>
</html>