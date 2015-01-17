<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error register</title>
</head>
<body>
	<c:set var="errorCode1" value = "${errorCode}" />
	
	<c:choose>
		<c:when test = " ${errorCode1 == 'invalidUsernameFormat' }">
			Username only can include a-z, A-Z, 0-9, _, -<br>
		</c:when>
		<c:when test = "${errorCode1 == 'usernameExist' }">
			The username has existed <br>
		</c:when>
		<c:when test = "${errorCode1 == 'invalidPasswordFormat' }">
			1. length must be at least 8 and not more than 16.<br>
			2. must include at least one capital letter<br>
			3. can not include space<br>
		</c:when>
		<c:otherwise>
			errorCode has no value
		</c:otherwise>
	</c:choose>
	<br>
	<form method="POST" action="/RestPractice_first/login">
		name: <input type="text" name="userName">
		Id: <input type="password" name="Id">
		<input type="submit" name="login" value="login">
	</form>
	<a href="/RestPractice_first/register">register</a>
</body>
</html>