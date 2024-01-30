<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberVO vo = (MemberVO)request.getAttribute("vo");

%>
<h2> 회원 검색 결과</h2> <br>
ID: <%= vo.getId() %> <br>
NAME <%= vo.getName() %> <br>
ADDRESS <%= vo.getAddress() %> <br><br><br>
<hr>
<h2> 회원 검색 결과 - EL</h2>
ID : ${vo.id}<br>
Name : ${vo.name}<br>
Address : ${vo.address}

</body>
</html>