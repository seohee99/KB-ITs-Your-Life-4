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

<h2> 회원 검색 결과 - EL</h2>
ID : ${vo.id}<br>
Name : ${vo.name}<br>
Address : ${vo.address}

</body>
</html>