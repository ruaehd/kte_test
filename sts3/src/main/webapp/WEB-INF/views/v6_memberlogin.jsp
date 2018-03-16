<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>v6_member</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
	<div class="container">
		<form:form action="v6_memberlogin.do" modelAttribute="vo" method="post">
			<form:input type="text" id="mem_id" path="mem_id" /><br/>
			<form:input type="password" id="mem_pw" path="mem_pw" /><br/>
			<input type="checkbox" id="chk_save" />아이디/암호 저장<br/>
			<input type="submit" id="btn_login" class="btn btn-success" value="로그인" />
		</form:form>
	</div>
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			//마지막 체크상태 확인
			var ck_is = $.cookie('ck_is');
			//체크된 상태로 종료 되었다면
			if(ck_is =='y'){
				//쿠키에서 아이디, 암호값을 읽음
				var id = $.cookie('ck_id');
				var pw = $.cookie('ck_pw');
				
				//input type에 값을 채움
				$('#mem_id').val(id);
				$('#mem_pw').val(pw);
				$('#chk_save').attr('checked', true);
			}
			
			
			$('#btn_login').click(function(){
				if($('#chk_save').is(":checked")){
					var id = $('#mem_id').val();
					var pw = $('#mem_pw').val();
					//쿠키 파일에 저장
					$.cookie('ck_is', 'y', {expires:1});
					$.cookie('ck_id', id, {expires:1});
					$.cookie('ck_pw', pw, {expires:1});
					
				}
				else{
					$.cookie('ck_is', 'n', {expires:1});
					$.cookie('ck_id', '');
					$.cookie('ck_pw', '');
				}
			});
		});
	</script>
</body>
</html>
