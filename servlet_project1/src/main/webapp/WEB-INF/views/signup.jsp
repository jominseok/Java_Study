<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<!-- 아이디, 비번, 비번확인, 이메일을 입력받아 서버로 전송하는 코드 get과 post중에 선택해서 전송 -->
	<form action="<%request.getContextPath();%>" method = "Post">	
		<label for = "id">아이디</label>
		<input type = "text" name = "id">
		<br>
		<label for = "pw">패스워드</label>
		<input type = "password" name = "pw">
		<br>
		<label for = "pw2">패스워드 확인</label>
		<input type = "password" name = "pw2">
		<br>
		<label for = "email">이메일</label>
		<input type = "email" name = "email">
		<br>
		<button>확인</button>
	</form>
</body>
</html>