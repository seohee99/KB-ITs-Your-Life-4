<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 
���� ���ε� ��� ��� �� ������ ��
1. form �±� �ȿ� input type="file"�� ���� �����
2. method=post�� ������
3. multipart/form-data
4. poem.xml�� fileupload dependency �߰�
5. ���� ���ε��� ������ �����ϴ� vo�� ���� ����� ��û�� ó���Ѵ� (requestmapping)
 -->
</head>
<body>
<h2 align="center">File Upload Form</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
	����ڸ� <input type="text" name="userName">
	<input type="file" name="uploadFile"> <!-- uploadForm�̸����� vo �������� :: ���⿡ ���ε��� ������ ����ȴ� -->
	<input type="submit" name="���Ͼ��ε�">
</form>

</body>
</html>