<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>v7_회원가입</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<form:form action="v7_memberjoin.do"	method="post" modelAttribute="obj">
		아이디<form:input type="text" path="mem_id" id="mem_id"/><label id="lbl-idcheck">아이디 중복확인</label><br />
		암호<form:input type="password" path="mem_pw" /><br />
		암호확인<input type="password" /><br />
		이름<form:input type="text" path="mem_name" /><br />
		전화번호<form:input type="text" path="mem_tel" /><br />
		이메일<form:input type="text" path="mem_email" /><br />
		<input type="submit" id="btn_join" value="회원가입" />
		</form:form>
	</div>

	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
	
	<script>
		$(function() {
			$('#mem_id').keyup(function(event){
				var id = $('#mem_id').val();
				if(id.length == 0){
					$('#lbl_idcheck').text('아이디중복확인');
				}
				else{
					$.post('v7_ajax_idcheck.do', {"mem_id":id}, function(data){
						if(data.ret == 'n'){
							$('#lbl-idcheck').text('사용불가');
						}
						else{
							$('#lbl-idcheck').text('사용가능');
						}
					});
				}
			});
			
			$('#btn_join').click(function(){
				var id = $('#mem_id').val();
				if(id.length == 0){
					alert('아이디를 입력하세요');
					$('#mem_id').focus();
					return false;
				}
				
				var idchk = $('#lbl-idcheck').text();
				if(idchk != '사용가능'){
					alert('사용불가 아이디 입니다. 다시 입력하세요');
					$('#mem_id').focus();
					return false;
				}
			});
		});
	</script>	
</body>
</html>
