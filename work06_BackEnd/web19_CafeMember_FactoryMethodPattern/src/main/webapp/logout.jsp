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
		//자바 스크림트에서 페이지 연결
		location.href = "index.jsp";
	}
</script>
</head>
<body onload="return logout()">
<b>로그아웃 되셨습니다...</b><br>
<a href="index.jsp">INDEX</a>
</body>
</html>




