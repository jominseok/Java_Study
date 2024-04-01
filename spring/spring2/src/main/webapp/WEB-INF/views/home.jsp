<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- 
	서버로 ID를 입력해서 전송하도록 코드를 작성해서 테스트 해보세요
	테스트 결과 STS콘솔창에서 화면에 본내 ID가 출력
	- STS 콘솔창에 화면에서 보낸 ID가 출력
	1. 화면구성(링크추가)
		- 보낼 URL을 선정 : /id
		- 보낼 방식 : get
		- 보낼 데이터의 변수명 : id
	2. 컨트롤러에 메서드 확인
		- 없으면 추가, 있으면 수정
		- URL을 처리하는 메서드가 없으면 추가, 있으면 수정
		- 작업
		- 작업이 끝난 후 보낼 화면이나 URL을 설정
 -->
 	<%-- <form action="<c:url value="/id"/>" method="get">
	 	<input type = "text" name="id"/>
	 	<button type="submit">전송</button>
 	</form> --%>
 	<h1>${hi}</h1>
 	<!-- 
 		a태그를 이용하여 서버에 이름을 전송해서 STS 콘솔창에 출력하는 코드를 작성하세요
 		1. 링크 추가
 			- URL : /name
 			- 전송할 변수명 : name
 			- 전송할 이름 : 홍길동
 		2. 컨트롤러에 메서드 확인  
 			- 
 	 -->
 	<a  href="<c:url value="/name?name=홍길동"/>">가나다</a>
 	<!-- 
 		LoginDTO 클래스를 이용하여 id와 비번을 서버로 전송하고,
 		서버에서는 화면에서 보낸 id와 pw를 콘솔창에 출력하는 코드를 작성
 		0. LoginDTO추가
 			- id와 pw
 			- 작업의 편리를 위해 lombok 연결
 		1. 링크 추가
 			- URL : /login
 		2. 컨트롤러 메서드 확인
 			- 콘솔창에 id와 pw이 담긴 LoginDTO 객체를 출력한 후 test.jsp로 연결
 	 -->
 	 <form action="<c:url value="/login"/>" method="post">
 	 	<div>
 	 		<label>id</label>
 	 		<input type="text" name="id">
 	 	</div>
 	 	<div>
 	 		<label>pw</label>
 	 		<input type="password" name="pw">
 	 	</div>
 	 	<button type="submit">전송</button>
 	 </form>
 	 
 	 <a href="<c:url value="/send/object"/>">객체 여러개를 서버에 전송하기</a>
 	 <a href="<c:url value="/send/path/123"/>">경로에 데이터를 추가해서 전송하기</a>
 	 <a href='<c:url value="/ajax"/>'>ajax예제</a>
</body>
</html>
