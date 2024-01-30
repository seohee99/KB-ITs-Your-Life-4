<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b> 1. JSP 기본 Element로 받아오기(이전 방식)</b> <br>
ServletRequest에 바인딩 된 값 :: <%= request.getAttribute("RESULT1") %> <br>
HttpSession에 바인딩 된 값 :: <%= session.getAttribute("RESULT2") %> <br>

<hr>
<b> 2. JSP EL로 받아오기 </b> <br>
ServletRequest에 바인딩 된 값 :: ${RESULT1} <br>
<!--  ${RESULT1} :: request.getAttribute("RESULT1") -->
HttpSession에 바인딩 된 값 :: ${RESULT2} <br><br>
<!--  ${RESULT2} :: 
					request.getAttribute("RESULT2") : 없으므로 넘어감!
					session.getAttribute("RESULT2") -->
연산 가능 :: ${RESULT2 + 100} <br>
</body>
</html>