<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>test</title>
</head>
<body>
<!-- 객체.변수명을 호출하면 멤버변수가 호출되는것이 아니라 멤버변수의 getter가 호출됨 -->
<h1>아이디 : ${user.id}</h1>
<h1>아이디 : ${user.pw}</h1>
<h1>아이디와 비번 : ${user.idPw}</h1>
<!-- 
축구, 야구, 농구, 테니스, 음악감상 중에서 취미를 선택해서 서버에 전송하는 코드를 작성 
서버에서는 화면에서 보낸 취미를 콘솔에 출력하고 메인페이지로 리다이렉트
	- 다중 선택이 가능
	- 첨부파일
-->

<form action='<c:url value="/hobby"/>' method="get">
	<h1>당신의 취미는?</h1>
	축구<input type="checkbox" name="hobby" value="축구">
	농구<input type="checkbox" name="hobby" value="농구">
	야구<input type="checkbox" name="hobby" value="야구">
	음악감상<input type="checkbox" name="hobby" value="음악감상">
	<button type="submit">전송</button>
</form>

</body>
</html>