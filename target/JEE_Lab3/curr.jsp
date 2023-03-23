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
			<th>&#164;</th>
			<th>Валюта</th>
			<th>Курс</th>
		</tr>
		<c:forEach var="currency" items="${requestScope.currencies}">
			<tr>
				<td><c:choose>
						<c:when test="${currency.name == 'USD'}">
							$
						</c:when>
						<c:when test="${currency.name == 'EUR'}">
							€
						</c:when>
						<c:otherwise>
							&#164;
						</c:otherwise>
					</c:choose></td>
				<td><c:out value="${currency.name}" /></td>
				<td><c:out value="${currency.rate}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>