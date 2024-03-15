<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html> 
<html>
<head>
	<title>스프링 - 게시글 들록</title>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<form action="<c:url value="/board/insert"/>" method="post" enctype="multipart/form-data">
		<h1>게시글 등록</h1>
		<div class="form-group">
			<label for="bo_title">게시판</label>
			<select name="bo_co_num" class="form-control">
				<c:forEach items="${list}" var="co">
					<option value="${co.co_num}">${co.co_name}</option>
				</c:forEach>
			</select>
		  <label for="bo_title">제목:</label>
		  <input type="text" class="form-control" id="bo_title" name="bo_title">
		</div>
		<div class="form-group">
		  <label for="bo_content">내용:</label>
		  <textarea class="form-control" id="bo_content" name="bo_content"></textarea>
		</div>
		<div class="form-group">
		  <label for="bo_content">첨부파일(최대 3개)</label>
		  <input type="file" class="form-control" name="file">
		  <input type="file" class="form-control" name="file">
		  <input type="file" class="form-control" name="file">
		</div>
		<button class="btn btn-outline-success col-12">게시글 등록</button>
	</form>
	
	<script type="text/javascript">
	//서버에 전송하기 전에 제목, 내용 글자수 확인
		$("form").submit(function(){
			let title = $("[name=bo_title]").val();
			if(title.length==0){
				alert("제목은 한 글자 이상이어야 합니다.")
				$("[name=bo_title]").focus();
				return false;
			}
			let content = $("[name=bo_content]").val();
			if(content.length==0){
				alert("제목은 한 글자 이상이어야 합니다.")
				$("[name=bo_content]").focus();
				return false;
			}
		})
		
	$('[name=bo_content]').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 100
      });
	</script>
</body>
</html>