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
<!-- ��ü.�������� ȣ���ϸ� ��������� ȣ��Ǵ°��� �ƴ϶� ��������� getter�� ȣ��� -->
<h1>���̵� : ${user.id}</h1>
<h1>���̵� : ${user.pw}</h1>
<h1>���̵�� ��� : ${user.idPw}</h1>
<!-- 
�౸, �߱�, ��, �״Ͻ�, ���ǰ��� �߿��� ��̸� �����ؼ� ������ �����ϴ� �ڵ带 �ۼ� 
���������� ȭ�鿡�� ���� ��̸� �ֿܼ� ����ϰ� ������������ �����̷�Ʈ
	- ���� ������ ����
	- ÷������
-->

<form action='<c:url value="/hobby"/>' method="get">
	<h1>����� ��̴�?</h1>
	�౸<input type="checkbox" name="hobby" value="�౸">
	��<input type="checkbox" name="hobby" value="��">
	�߱�<input type="checkbox" name="hobby" value="�߱�">
	���ǰ���<input type="checkbox" name="hobby" value="���ǰ���">
	<button type="submit">����</button>
</form>

</body>
</html>