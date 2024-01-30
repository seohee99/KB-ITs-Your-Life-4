<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
[서블릿 로직 순서] 
1. 폼값 받아서
2. 받은 값으로 vo 생성..(생략가능)
3. DAO return 받고 비즈니스 로직 호출
4. 반환 값..Attribute 바인딩
5. 결과 페이지 이동..네비게이션
-->
<%
	MemberVO vo = new MemberVO("1", "1", "1", "1");
	request.setAttribute("vo", vo);
	request.getRequestDispatcher("EL3_View.jsp").forward(request, response);
%>
</body>
</html>