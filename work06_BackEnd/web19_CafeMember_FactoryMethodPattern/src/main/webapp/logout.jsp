<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("Log Out~~")
		//�ڹ� ��ũ��Ʈ���� ������ ����
		location.href = "index.jsp";
	}
</script>
</head>
<body onload="return logout()">
<b>�α׾ƿ� �Ǽ̽��ϴ�...</b><br>
<a href="index.jsp">INDEX</a>
</body>
</html>




