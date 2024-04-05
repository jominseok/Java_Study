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
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <form action="<c:url value="/post/insert" />" method="post" enctype="multipart/form-data">
  <h1>게시글 등록</h1>
   <div class="form-group">
      <label for="title">게시판:</label>
      <select class="form-control" name="bo_co_num">		
     		<c:forEach items="${board}" var="board">
				<option value="${board.co_num}">${board.co_name}</option>
     		</c:forEach>
		</select>
    </div>
    <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" name="bo_title">
    </div>
    <div class="form-group">
      <label for="content">내용:</label>
      <textarea class="form-control" id="content" name="bo_content"> </textarea>
    </div>
		<div class="form-group">
			<label>파일</label>
			<input type="file" class="form-control" name="files"/>
			<input type="file" class="form-control" name="files"/>
			<input type="file" class="form-control" name="files"/>
		</div>
    <button type="submit" class="btn btn-primary col-12">등록하기</button>
  </form>
 
</div>
</body>
</html>