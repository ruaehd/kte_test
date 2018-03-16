<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>로그인</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:800px; padding:30px 0; margin:0 auto">
			<form:form action="memberlogin.do" modelAttribute="vo" method="post" class="form-horizontal">
				<h3>로그인</h3>
				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-4 control-label" for="email">Email</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="email" path="email" placeholder="이메일 주소를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="pw">비밀번호</label>
					<div class="col-sm-5">
						<form:input type="password" class="form-control" id="pw" path="pw" placeholder="비밀번호를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label"></label>
					<div class="col-sm-5">
						<input type="checkbox" id="chk_save" />이메일/암호 저장
					</div>
				</div>
				

				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
						<input type="submit" id="btn_login" class="btn btn-success" value="로그인" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
	
	<script src="resources/js/jquery-1.9.1.min.js"></script>
	<script src="resources/js/jquery.cookie.js"></script>
	<script>
		$(function(){
			//페이지가 로딩되면
			var ck = $.cookie('c_ck');
			console.log(ck);
			if(ck=='y'){
				var em = $.cookie('c_em');
				var pw = $.cookie('c_pw');
				$('#email').val(em);
				$('#pw').val(pw);
				$('#chk_save').attr('checked', true);
			}
			
			//로그인버튼이 클릭되면
			$('#btn_login').click(function(){
				//체크된 상태면
				if($('#chk_save').is(":checked")){
					//이메일, 암호 값 읽기
					var em =$('#email').val();
					var pw =$('#pw').val();
					//쿠키에 저장
					$.cookie('c_em', em, {expires:1});	//이메일값 저장
					$.cookie('c_pw', pw, {expires:1});	//암호값 저장
					$.cookie('c_ck', 'y', {expires:1});	//체크박스값 저장
				}
				//체크되지 않은 상태면
				else{
					//$.removeCookie('c_em');	//쿠키 삭제
					$.cookie('c_em', '');	//이메일값 저장
					$.cookie('c_pw', '');	//암호값 저장
					$.cookie('c_ck', 'n');	//체크박스값 저장
				}
			});
		})
	</script>
</body>
</html>
