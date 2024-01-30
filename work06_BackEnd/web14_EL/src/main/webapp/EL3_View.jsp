<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>정보 출력</b> <br><br>
${vo} <br> <!-- Attribute에 binding된 이름 -->
ID : ${vo.id} <br>
Address : ${vo.address} <br> <!-- request.getAttribute("vo").getId() -->
Name : ${vo.name} <br>

</body>
</html>