<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>����</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="<c:url value="/"/>">Logo</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<c:if test="${user == null}">
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/signup"/>">ȸ������</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/login"/>">�α���</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/board/list/"/>">�Խñ�</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<h1>�����������Դϴ�.</h1>
		<c:forEach begin="1" end="4" var="i"> ${i },</c:forEach>
		<c:set var="name" value="ȫ�浿1" />
		${name}
		<!-- eq : ���ٷ� ǥ�� ���� equals
			 ne : ���� �ʴٷ� ǥ�� ���� not equals
		  -->
		<c:if test='${name == "ȫ�浿"}'>ȫ�浿�Դϴ�.</c:if>

		<c:choose>
			<c:when test='${name == "ȫ�浿"}'>ȫ�浵�Դϴ�.</c:when>
			<c:otherwise>ȫ�浿�� �ƴմϴ�.</c:otherwise>
		</c:choose>
		<!-- �������� ���� id�� "abc"�� �Ǿ� ������ -->
		<input type="text" value="${id}"> <br>
		<c:forTokens items="a/b/c/d" delims="/" var="ch">${ch}</c:forTokens>
		<br>
		<c:url value="/" var="url">
			<c:param name="name" value="ȫ�浿" />
			<c:param name="age" value="30" />
		</c:url>
		${url}
	</div>
</body>
</html>



















