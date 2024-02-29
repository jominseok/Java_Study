<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container">
		<!-- 서버에서 보낸 데이터를 c:forEach를 이용하여 화면에 출력 -->
		<!-- 서버에서 보낸 게시글 리스트를 간단하게 출력하는 코드 -->
		<h1>게시글 리스트</h1>
		<!-- 
		form태그를 이용하여 검색창을 추가
		타입의 name을 type으로 지정. 왜? Criteria에 type으로  되어 있어서
		검색어의 name을 search로 지정
		form태그의 action을 /board/list로 보냄
		 -->
		<form action='<c:url value="/board" />'>
			<div class="input-group mb-3">
				<select class="form-control" name="type">
					<option value="all">전체</option>
					<option value="bo_title">제목</option>
					<option value="bo_me_id">작성자</option>
				</select>
					<input type="text" class="" name="search" placeholder="검색어">
					<button class="btn btn-outline-success">검색</button>
			</div>
		</form>
		<table class="table">
			<thead>
				<tr>
					<th>게시글 번호</th>
					<th>게시판 번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.bo_num}</td>
						<td>${board.community.co_name}</td>
						<td><a href="<c:url value = "#" />"> ${board.bo_title}</a></td>
						<td><a href="<c:url value = "#" />"> ${board.bo_me_id}</a></td>
						<td>${board.bo_view}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-primary" href="<c:url value="/board/insert"/>">글
			등록</a>
	</div>
</body>
</html>