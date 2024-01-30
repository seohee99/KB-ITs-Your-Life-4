<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<thead>
		<th>ID</th>
		<th>NAME</th>
		<th>ADDRESS</th>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>  ${vo.id} </td>
				<td>  ${vo.name} </td>
				<td>  ${vo.address} </td>
			</tr>
		</c:forEach>
	</tbody>

</table>


</body>
</html>