<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 
파일 업로드 기술 사용 시 주의할 점
1. form 태그 안에 input type="file"로 폼을 만든다
2. method=post만 가능함
3. multipart/form-data
4. poem.xml에 fileupload dependency 추가
5. 파일 업로드한 정보를 저장하는 vo를 먼저 만들고 요청을 처리한다 (requestmapping)
 -->
</head>
<body>
<h2 align="center">File Upload Form</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
	사용자명 <input type="text" name="userName">
	<input type="file" name="uploadFile"> <!-- uploadForm이름으로 vo 만들어야함 :: 여기에 업로드한 파일이 저장된다 -->
	<input type="submit" name="파일업로드">
</form>

</body>
</html>