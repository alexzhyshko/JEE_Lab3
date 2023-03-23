<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Курси валют</title>
</head>
<body>
	<fmt:formatDate value="${today}" pattern="HH" var="curdate" />
	<h1>Курси валют на поточний день:</h1>
	<h2>
		<c:out value="${today}" />
	</h2>
	<c:if test='${curdate le 8 or curdate ge 17}'>
		<h2 style="color:red;">Біржа вже закрита, курс не змінюється</h2>
	</c:if>
	<table>
		<tr>
			<th>Валюта</th>
			<th>Курс</th>
		</tr>
		<c:forEach var="exchangeDate" items="${requestScope.exchangeDates}">
			<tr>
				<td><c:out value="${exchangeDate.rate.currency.code}" /></td>
				<td><c:out value="${exchangeDate.rate.rate}" /></td>
			</tr>
		</c:forEach>
	</table>
	<h1>Курсу валюти за заданий проміжок часу:</h1>
	<c:set var="currencies_for_periodUrl" scope="page" value="/JEE_Lab3/home/currencies_for_period"/>
	<form action="/JEE_Lab3/home/currencies_for_period" method="GET">
		<label for="startDate">Початкова дата:</label>
		<input type="date" name="startDate" value="${startDate}" required>
		<label for="endDate">Кінцева дата:</label>
		<input type="date" name="endDate" value="${endDate}" required>
		<label for="currency">Валюта:</label>
		<select name="currency">
			<option value="value1">USD</option>
			<option value="value2" selected>EUR</option>
		</select>
		<button type="submit">Отримати курси</button>
	</form>
	<c:if test="${not empty exchangeRates}">
		<table>
			<thead>
			<tr>
				<th>Дата</th>
				<th>Курс обміну</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="exchangeRate" items="${exchangeRates}">
				<tr>
					<td><c:out value="${exchangeRate.currency.code}"/></td>
					<td><c:out value="${exchangeRate.rate}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
