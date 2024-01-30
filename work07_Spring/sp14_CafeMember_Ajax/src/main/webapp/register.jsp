<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
 <!-- jquery cdn ::  cloudflare, google, ms, jquery -->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
form{
    width: 300px;
    margin: 0 auto;
}
</style>
<script>

    $(function(){
        $('#id').keyup(function(){
            var id =$(this).val();
            //id값이 4자 이상 8자 이하일 때만 id값을 받아들이겟다.
            if(id.length >= 4 & id.length <=8){
                //이 때만 비동기 요청
                $.ajax({
                    type:'post',
                    url:'idExist.do',
                    data:'id='+id,

                    success:function(data){ //callback
                        //이미 사용중인 아이디......idcheck 영역에 출력
                        //사용가능 아이디...idcheck 영역에 출력
                         var jsonData=JSON.parse(data); //[object:object]로 나오는 것을 방지
                        if(jsonData.check ==true){
                            $('#idcheck').html("<h3><font color=tomato>중복된 아이디</font></h3>");
                            $('#submit_btn').attr('disabled', true);
                        }
                        else{
                            $('#idcheck').html("<h3><font color=blue>사용가능  아이디</font></h3>");
                            $('#submit_btn').attr('disabled', false);
                        }
                    }
                });//ajax
            }
            else{ //메세지 출력
                $('#idcheck').html('4자 이상, 8자 이하만 가능!!').css('color', 'orange');
                $('#submit_btn').attr('disabled', true); //비활성화
            }


        });
    });


</script>
</head>
<body>
<div class="container">
    <div class="jumbotron" align="center">
        <h2>REGISTER MEMBER FORM</h2>
    </div>
</div>
<hr>
<div class="container">
     <form action="register.do" method="post">
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter Id" name="id">
      <span id="idcheck" style="margin-left:15px"></span>
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
    </div>
        <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
        <div class="form-group">
      <label for="address">Address:</label>
      <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address">
    </div>
 
    <button type="submit" class="btn btn-primary" id="submit_btn">Submit</button>
  </form>

</div>

</body>
</html>