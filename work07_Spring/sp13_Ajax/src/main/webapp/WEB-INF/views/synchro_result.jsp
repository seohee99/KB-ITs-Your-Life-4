<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	$(function() {
		// 버튼 클릭하면 함스 호출
		$('#asyncro').click(function() {
			// 비동기 시작
			$.ajax({
				// 요청
				type:'get',
				url:'asynch',
				
				//응답
				success:function(data){ // 객체 단위로 데이터를 받아옴(JSON)
					//alert(data)
					var jsonData = JSON.parse(data);
					$('#jsonView').html("<h3><font color=tomato" + jsonData.person.name + "님이 사는 곳은 " + jsonData.person.address + "</font></h3>")
				}
			})
		})
	})
</script>
</head>
<body>
<h3>${info}</h3>
<p></p>
<hr>
<p></p>

<input type="button" value="비통기 통신 시작하기" id="asyncro"> 
<span id="jsonView"> </span>

</body>
</html>