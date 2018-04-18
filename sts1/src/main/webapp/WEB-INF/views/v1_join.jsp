<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>v1_join</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:600px; padding:30px 0; margin:0 auto">
			<form action="join.do" method="post" id="form">
				<h3>회원가입</h3>
				<hr />
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">회원번호</label>
					<input type="text" name="id" id="id" class="form-control" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">비밀번호</label>
					<input type="password" name="pw" id="pw" class="form-control" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px"></label>
					<input type="password" name="pw1" id="pw1" class="form-control" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">이름</label>
					<input type="text" name="name" class="form-control" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">생년월일</label>
					<input type="text" name="birth" class="form-control" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">전화번호</label>
					<input type="text" name="tel" class="form-control" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">휴대폰</label>
					<input type="text" name="phone" class="form-control" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">우편번호</label>
					<input type="text" name="postcode" class="form-control" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">주소</label>
					<input type="text" name="addr" class="form-control" />
				</div>
				
				<hr />
				<div align="right">
					<input type="submit" class="btn btn-success" value="회원가입" />
				</div>
			</form>
		</div>
	</div>
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="resources/js/additional-methods.min.js"></script>
	<script type="text/javascript" src="resources/js/localization/messages_ko.min.js"></script>
	
	<script>
		$(function(){
			$('#form').validate({
				/* 
				required : true => 비어있는지 확인
				digits : true => 숫자만 가능
				minlength : 5 => 최소길이 5자이상
				email : true => 이메일 형식만 가능(ex abc@naver.com)
				agree : "required" => 체크박스에 체크가 되어야함 
				*/
				submitHandler : function(){
					var f = confirm("회원가입을 하시겠습니까?");
					if(f){
						return true;
					} else{
						return false;
					}	
				},
				rules:{
					id:{
						required : true,
						minlength : 5,
						remote : 'idcheck.do?'
					},
					pw:{
						required : true,
						minlength : 5
					},
					pw1:{
						required : true,
						minlength : 5,
						equalTo : pw
					},
					name:{
						required : true
					},
					birth:{
						required : true,
						digits : true
					},
					tel:{
						required : true,
						digits : true
					},
					phone:{
						required : true,
						digits : true
					},
					postcode:{
						required : true,
						digits : true,
						rangelength: [5, 5]
					},
					addr:{
						required : true
					}
				},
				messages:{
					id:{
						required : '내용이 없습니다',
						minlength : '5자이상 입력하세요',
						remote : '아이디가 중복입니다'
					},
					pw:{
						required : '내용이 없습니다',
						minlength : '5자이상 입력하세요'
					},
					pw1:{
						required : '내용이 없습니다',
						minlength : '5자이상 입력하세요',
						equalTo : '암호가 일치하지 않습니다'
					},
					name:{
						required : '내용이 없습니다'
					},
					birth:{
						required : '내용이 없습니다',
						digits : '숫자만 입력 가능합니다'
					},
					tel:{
						required : '내용이 없습니다',
						digits : '숫자만 입력 가능합니다'
					},
					phone:{
						required : '내용이 없습니다',
						digits : '숫자만 입력 가능합니다'
					},
					postcode:{
						required : '내용이 없습니다',
						digits : '숫자만 입력 가능합니다',
						rangelength: '5자리 값으로 입력하세요'
					},
					addr:{
						required : '내용이 없습니다'
					}
				}
			});
			
		});
	</script>
</body>
</html>
