<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<!-- id와 pw를 입력받아 서버로 전송하는 코드를 작성 post 방식으로 전송-->
	<h1>로그인화면</h1>
	<form action="<%request.getContextPath();%>" method = "post">
		<label for = "id">id</label>
		<input type = "text" name = "id">
		<br>
		<label for = "pw">pw</label>
		<input type = "password" name = "pw">
		<br>
		<button>로그인</button>
	</form>
</body>
</html>