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

<form action='<c:url value="/send/object"/>' method="post">
	<div>
 		<label>id</label>
 		<input type="text" name="list[0].id">
 	</div>
 	<div>
 		<label>pw</label>
 		<input type="password" name="list[0].pw">
 	</div>
 	<div>
 		<label>id</label>
 		<input type="text" name="list[1].id">
 	</div>
 	<div>
 		<label>pw</label>
 		<input type="password" name="list[1].pw">
 	</div>
 	<div>
 		<label>id</label>
 		<input type="text" name="list[2].id">
 	</div>
 	<div>
 		<label>pw</label>
 		<input type="password" name="list[2].pw">
 	</div>
 	<button type="submit">전송</button>
</form>
</body>
</html>