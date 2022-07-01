<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
	<h2><spring:message code="member.info"/></h2>
	<form:form action="step3" modelAttribute="formData">
		<p>
			<spring:message code="email"/>:
			<form:input path="email"/>
			<form:errors path="email"/>
			<!-- 
				errors에서 메세지를 찾는 순서(우선순위)
				1. 에러코드.커맨드객체명.필드명 (required.formData.email=이거사용)
				2. 에러코드.필드명 (required.email=이거사용)
				3. 에러코드.필드타입 (required.java.lang.String=이거사용)
				4. 에러코드(required=이거사용)
			 -->
		</p>
		<p>
			<spring:message code="name"/>:
			<form:input path="name"/>
			<form:errors path="name"/>
		</p>
		<p>
			<spring:message code="password"/>:
			<form:password path="password"/>
			<form:errors path="password"/>
		</p>
		<p>
			<spring:message code="password.confirm"/>:
			<form:password path="confirmPassword"/>
			<form:errors path="confirmPassword"/>
			
		</p>
		<input type="submit" value="<spring:message code="register.btn"/>">
	</form:form>
</body>
</html>








