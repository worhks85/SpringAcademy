<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
</head>
<body>

<form:form modelAttribute="loginCommand">
<form:errors /> <!-- 글로벌 에러코드에 대한 메시지가 표현될 부분 -->
	<p>
		<spring:message code="email"/>:
		<form:input path="email"/>
		<form:errors path="email"/>
	</p>
	<p>
		<spring:message code="password"/>:
		<form:password path="password"/>
		<form:errors path="password"/>
	</p>
	<input type="submit" value="<spring:message code="login.btn"/>">
</form:form>
</body>
</html>








