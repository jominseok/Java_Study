<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>게시글 리스트</h1>
		<form action="<c:url value="/post/list"/>" id="searchForm">
			<div class="input-group mb-3">
				
				<select name="type" class="form-control">
					<option value="all" <c:if test="${pm.cri.type=='all'}">selected</c:if>>전체</option>
					<option value="writer" <c:if test="${pm.cri.type=='writer'}">selected</c:if>>작성자</option>
					<option value="title" <c:if test="${pm.cri.type=='title'}">selected</c:if>>제목+내용</option>
				</select>
			  <input type="text" class="form-control" placeholder="Search" name ="search" value="${pm.cri.search}">
			  <div class="input-group-append">
			    <button class="btn btn-success" type="submit">검색</button>
			  </div>
			</div>
			<select class = "form-control offset-8 col-4 mb-4" name="order">
				<option value="bo_num" <c:if test="${pm.cri.order == 'bo_num'}">selected</c:if>>최신순</option>
				<option value="bo_view" <c:if test="${pm.cri.order == 'bo_view'}">selected</c:if>>조회수순</option>
			</select>
		</form>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board" varStatus="vs">
					<tr>
						<td>${pm.totalCount - vs.index - pm.cri.pageStart}</td>
						<td><a href="#">${board.bo_title}</a></td>
						<td>${board.bo_me_id}</td>
						<td>${board.bo_view}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination justify-content-center">
			<c:if test="${pm.prev}">
				<li class="page-item"><c:url var="url" value="/post/list">
						<c:param name="page" value="${pm.startPage - 1}" />
						<c:param name="type" value="${pm.cri.type}"/>
						<c:param name="search" value="${pm.cri.search}"/>
						<c:param name="order" value="${pm.cri.order}"/>
					</c:url> <a class="page-link" href="${url}">이전</a></li>
			</c:if>
			<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
				<c:set var="active" value="${pm.cri.page == i ?'active':'' }" />
				<li class="page-item ${active}"><c:url var="url"
						value="/post/list">
						<c:param name="page" value="${i}" />
					</c:url> <a class="page-link" href="${url}">${i}</a></li>
			</c:forEach>
			<c:if test="${pm.next}">
				<li class="page-item"><c:url var="url" value="/post/list">
						<c:param name="page" value="${pm.endPage + 1}" />
						<c:param name="type" value="${pm.cri.type}"/>
						<c:param name="search" value="${pm.cri.search}"/>
						<c:param name="order" value="${pm.cri.order}"/>
					</c:url> <a class="page-link" href="${url}">다음</a></li>
			</c:if>
		</ul>
	</div>
	
	<script type="text/javascript">
		$("[name=order]").change(function(){
			$("#searchForm").submit({
				
			});
		})
	</script>
</body>
</html>