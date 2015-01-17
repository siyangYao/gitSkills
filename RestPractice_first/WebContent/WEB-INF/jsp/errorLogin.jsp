<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	error Login!!
	<br>
	<c:set var="errorCode" value="${errorCode}" />
	<c:choose>
		<c:when test="${ errorCode == 'errorUsername'}">
			username does not exist
		</c:when>
		<c:when test = "${errorCode == 'errorPassword'} ">
			password is incorrect
		</c:when>
		<c:otherwise>
			no comment
		</c:otherwise>
	</c:choose>
	<form method="POST" action="/RestPractice_first/login">
		name: <input type="text" name="userName">
		Id: <input type="password" name="Id">
		<input type="submit" name="login" value="login">
	</form>
	<a href="/RestPractice_first/register">register</a>
</body>
</html>