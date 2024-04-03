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
<body>
	<div class="container">   
	<h1>게시글 리스트</h1>
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
	        <td>
	        	<a href="#">${board.bo_title}</a>
	        </td>
	        <td>${board.bo_me_id}</td>
	        <td>${board.bo_view}</td>
	      </tr>
	    </c:forEach>
	    </tbody>
	  </table>
	  <ul class="pagination justify-content-center">
	  	<c:if test="${pm.prev}">
		    <li class="page-item">
		    	<c:url var="url" value="/post/list">
		    		<c:param name="page" value="${pm.startPage - 1}"/>
		    	</c:url>
		    	<a class="page-link" href="${url}">이전</a>
		    </li>
	  	</c:if>
	  	<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
	  		<c:set var="active" value="${pm.cri.page == i ?'active':'' }"/>
		    <li class="page-item ${active}">
		    	<c:url var="url" value="/post/list">
		    		<c:param name="page" value="${i}"/>
		    	</c:url>
		    	<a class="page-link" href="${url}">${i}</a>
		    </li>
	  	</c:forEach>		    
	  	<c:if test="${pm.next}">
		    <li class="page-item">
		   		<c:url var="url" value="/post/list">
		    		<c:param name="page" value="${pm.endPage + 1}"/>
		    	</c:url>
		    	<a class="page-link" href="${url}">다음</a>
		    </li>
		</c:if>
	  </ul>
	</div>
</body>
</html>