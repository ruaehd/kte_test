<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>회원가입</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<div class="row" style="margin-top:20px">
			<div class="col-md-6" style="border-right:0px solid #cccccc">
				<div style="width:440px;margin:0 auto;">
				<h4>회원가입</h4>
				<hr />
				<form:form action="v9_customerjoin.do"
					method="post" modelAttribute="vo">
					<div class="form-inline" style="margin-bottom:5px">	
						<label style="width:100px">아이디</label>
						<form:input type="text" path="id" class="form-control" placeholder="아이디" />
						<label id="label_idcheck">아이디중복확인</label>
					</div>
					
					<div class="form-inline" style="margin-bottom:5px">	
						<label style="width:100px">암호</label>
						<form:input type="password" path="pw" class="form-control" placeholder="암호" />
					</div>
					
					<div class="form-inline" style="margin-bottom:5px">	
						<label style="width:100px">암호확인</label>
						<input type="password" id="pw1" class="form-control" placeholder="암호확인" />
						<label id="label_pwcheck">암호확인</label>
					</div>
					
					<div class="form-inline" style="margin-bottom:5px">	
						<label style="width:100px">이름</label>
						<form:input type="text" path="name" class="form-control" placeholder="이름" />
					</div>
					<div align="right" style="margin-top:30px">
						<input type="submit" class="btn btn-success" value="회원가입" />
					</div>
				</form:form>	
				</div>
			</div>
			<div class="col-md-6">
				<img src="resources/imgs/Tulips.jpg" width="100%" height="600px" />
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.twbsPagination-1.3.1.js"></script>
	<script>
		$(function(){
			$('#pw1').keyup(function(){
				var pw = $('#pw').val();
				var pw1 = $('#pw1').val();
				if(pw1.length > 0){
					if(pw == pw1){
						$('#label_pwcheck').text('암호일치');
					}
					else{
						$('#label_pwcheck').text('암호불일치');
					}
				}
				else{
					$('#label_pwcheck').text('암호확인');
				}
			});
			
			
			$('#id').keyup(function(){
				var id = $('#id').val();
				if( id.length > 0 ){
					$.get('v9_ajax_customeridcheck.do?id='+id,
								function(data){
						if(data.ret == 0){
							$('#label_idcheck').text('사용가능');
						}
						else if(data.ret == 1){
							$('#label_idcheck').text('사용불가');
						}
						else if(data.ret == -1){
							$('#label_idcheck').text('사용불가');
						}
					},'json');
				}
				else{
					$('#label_idcheck').text('아이디중복확인');
				}
			});
		});
	</script>	
</body>
</html>
