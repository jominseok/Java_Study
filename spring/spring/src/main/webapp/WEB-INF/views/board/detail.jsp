<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div>
	<h1>�Խñ� ��</h1>
	<div>
		<label>����</label>
		<div class="form-control">${board.bo_title}</div>
	</div>
	<div>
		<label>�ۼ���</label>
		<div class="form-control">${board.bo_me_id}</div>
	</div>
	<div>
		<label>��ȸ��</label>
		<div class="form-control">${board.bo_view}</div>
	</div>
	<div class="input-group mb-3 mt-3">
		<button class="btn btn-outline-success btn-up col6">��õ(${board.bo_up})</button>
		<button class="btn btn-outline-success btn-down col6 float-end">����õ(${board.bo_down})</button>
	</div>
	<div>
		<label>����</label>
		<div class="form-control" style="min-height : 400px">${board.bo_content}</div>
	</div>
	<div>
		<label>÷������</label>
		<c:choose>
			<c:when test="${fileList.size() != 0}">	
				<div>÷������ ����</div>
				<c:forEach items="${fileList}" var="file">
					<a href="<c:url value="/download${file.fi_name}"/>" 
					class="form-control" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
				</c:forEach>				
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<c:url value="/board/list" var="url">
			<c:param name="page" value="${cri.page}"/>
			<c:param name="type" value="${cri.type}"/>
			<c:param name="search" value="${cri.search}"/>
		</c:url>
		<a href="${url}" class="btn btn-outline-dark">�������</a>
	</div>
</div>
</body>
</html>