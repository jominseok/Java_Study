<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<!-- 
	회원가입 화면을 만들고, 회원가입하는 기능을 구현하세요
	1. header.jsp
	 - 회원가입 링크를 추가
	 - url : /signup
	2. HomeController
	 - url이 /signup이고, method가 get인 메서드를 추가
	 - /member/signup.jsp와 연결
	3. /member/signup.jsp를 생성 및 코드 작성
	 - 회원가입 코드를 구성
	 - form태그로, action은 /signup, method는 post
	4. 테스트
	 - 메뉴에 회원가입 링크를 클릭하면 회원가입 화면이 보이는지 확인
	5. MemberVO를 추가
	 - @Data, @NoArgsCotructor추가
	6. HomeController
	 - url이 /signup이고, method가 post인 메서드를 추가
	 - 화면에서 보낸 회원가입 정보를 MemberVO 객체에 담아옴
	 - log에 가져온 객체를 확인(선택)
	 - 서비스에게 회원 정보를 주면서 회원 가입 진횅하라고 시키고 가입 여부를 알려달라고 함
	 - 성공하면 메인페이지로 리다이렉트
	 - 실패하면 회원가입 페이지로 리다이렉트
	7. MemberService/MemberServiceImp
	 - 메서드 추가
	 - MemberVO 객체 null체크
	 - 아이디 중복확인
	 	- 다오에게 아이디를 주면서 회원 정보 가져오라고 시킴(7-1)
	 	- 회원 정보가 있으면 false를 리턴
	 - 비밀번호 암호화
	 	- 비밀번호 암호화를 위한 설정(공유 문서 참고)
	 	- 기존 비번을 암호화
	 	- 암호화 한 비번을 MemberVO에 객체에 업데이트
	 - 다오에게 회원가입을 시키고 성공 여부를 알려달라고 요청(7-2)
	 - 성공 여부를 리턴
	 
	 6. MemberDAO/MemberMapper
	 	- (7-1), (7-2) 메서드 추가 및 쿼리 구현
	 	- 다오에는 @Param 추가
	 	- Mapper에는 쿼리 구현
	 	- (7-1) 아이디를 이용하여 회원 정보를 가져오는 쿼리 작성 및 resultType설정
	 		- select 태그를 활용
	 	- (7-2) 회원 정보를 이용하여 회원 정보를 추가하는 쿼리 작성 
	 		- insert태그 활용 
 -->
 
 <!-- 
 	로그인 구현 순서
 	
 	1. header.jsp
 		- 링크 추가
 		- url : /login
 	2. HomeController
 		- 메서드 추가
 			- url : /login
 			- method : get
 			- jsp : /member/login
 	3. /member/login.jsp 추가 및 코드 작성
 		- form태그 활용
 			- action : /login
 			- method : post
 		- input태그에 name을 지정
 			- name은 MemberVO에 멤버 변수명에 맞춤
 	4. 테스트
 	5. HomeCOntroller
 		- 메서드 추가
 			- url : /login
 			- method : post
 			- jsp : message
 		- 기능 구현
 			- 로그인 정보를 서비스에게 주고 로그인 정보와 일치하는 회원 정보를 가져오라고 시킴
 			- 가져온 회원정보를 model에 
 			- 로그인 성공하면 
 				- message : 로그인 했습니다.
 				- url : 메인 페이지 실패하면 로그인 페이지로 이동하도록
 			- 로그인 실패하면
 				- msg : 로그인을 하지 못했습니다.
 				- url : /logins
  -->
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="<c:url value="/resources/img/bird.jpg"/>" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/login"/>">로그인</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 3</a>
    </li>
  </ul>
</nav>
	
</body>
</html>