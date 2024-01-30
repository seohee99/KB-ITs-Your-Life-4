<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	ArrayList<MemberVO> list = (ArrayList)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 나중에 이 부분은 Bootstrap 클래스 속성 연결해서 완전한 디자이능로 직접 만들어주세용 -->
<h2>회원 전체 명단 보기</h2>
<table>
<%
	for(MemberVO vo : list){
		
	
%>
	<tr>
		<td><%= vo.getId() %></td>
		<td><%= vo.getName() %></td>
		<td><%= vo.getAddress() %></td>
	
	</tr>
<%
	}
%>
</table>

</body>
</html>