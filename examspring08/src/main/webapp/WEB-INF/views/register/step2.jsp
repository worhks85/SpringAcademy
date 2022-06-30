<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스텝2</title>
</head>
<body>
<h2>회원정보 입력</h2>
	<form action="step3" method ="post">
	<p> 이메일: <input type ="text" name="email"> </p>
	<p> 이름: <input type ="text" name="name"> </p>
	<p> 비밀번호: <input type ="password" name="password"> </p>
	<p> 비밀번호확인: <input type ="password" name="confirmPassword"> </p>
	<input type ="submit" value="가입완료">
	</form>
</body>
</html>