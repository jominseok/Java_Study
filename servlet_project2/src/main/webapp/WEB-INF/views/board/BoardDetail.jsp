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
<meta charset="UTF-8">
<title>상세조회</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container">
		<form action="<c:url value="/board/insert"/>" method="post">
			<c:choose>
				<c:when test="${board != null}">
					<h1>게시글 상세조회</h1>
					<div class="mb-3 mt-3">
						<label for="community" class="form-label">게시판:</label> <input
							class="form-control" readonly value="${board.community.co_name}">
					</div>
					<div class="mb-3 mt-3">
						<label for="community" class="form-label">제목:</label> <input
							class="form-control" readonly value="${board.bo_title}">
					</div>
					<div class="mb-3 mt-3">
						<label for="community" class="form-label">작성자:</label> <input
							class="form-control" readonly value="${board.bo_me_id}">
					</div>
					<div class="mb-3 mt-3">
						<label for="community" class="form-label">조회수:</label> <input
							class="form-control" readonly value="${board.bo_view}">
					</div>
					<div class="mb-3 mt-3">
						<label for="community" class="form-label">내용:</label> <input
							class="form-control" readonly value="${board.bo_content}">
					</div>
				</c:when>
				<c:otherwise>
					<h1>없는 게시글이거나 삭제된 게시글 입니다.</h1>
				</c:otherwise>
			</c:choose>
			<a class="btn btn-outline-primary" href="<c:url value="/board"/>">목록으로</a>
			<c:if test="${user.me_id == board.bo_me_id}">
				<a class="btn btn-primary"
					href="<c:url value="/delete?num=${board.bo_num}"/>">글삭제</a>
			</c:if>
		</form>
	</div>
</body>
</html>