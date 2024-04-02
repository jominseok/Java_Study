<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<div class="container">
	<h1>회원 가입</h1>
	  <form action="<c:url value="/signup"/>" method="post">
	    <div class="form-group">
	      <label for="id">아이디:</label>
	      <input type="text" class="form-control" id="id" name="me_id" required>
	    </div>
	    <div class="form-group">
	      <label for="pw">비밀번호:</label>
	      <input type="password" class="form-control" id="pw" name="me_pw" >
	    </div>
	    <div class="form-group">
	      <label for="pw2">비밀번호 확인:</label>
	      <input type="password" class="form-control" id="pw2" name="pw2" >
	    </div>
	    <div class="form-group">
	      <label for="email">이메일:</label>	
	      <input type="email" class="form-control" id="email" name="me_email">
	    </div>
	    <button type="submit" class="btn btn-primary">회원가입</button>
	  </form>
	</div>
</body>
</html>