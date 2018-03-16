<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>비밀번호 변경</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:800px; padding:30px 0; margin:0 auto">
			<form:form action="memberchangepw.do" modelAttribute="vo" method="post" class="form-horizontal">
				<h3>비밀번호 변경</h3>
				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-4 control-label" for="email">Email</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="email" path="email" value="${vo.email}" readonly="true"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="pw">기존 비밀번호</label>
					<div class="col-sm-5">
						<form:input type="password" class="form-control" id="pw" path="pw" placeholder="기존 비밀번호를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="pw1">새 비밀번호</label>
					<div class="col-sm-5">
						<form:input type="password" class="form-control" id="pw1" path="pw1" placeholder="새 비밀번호를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label"></label>
					<div class="col-sm-5">
						<input type="password" class="form-control" id="pw2" placeholder="새 비밀번호를  다시 입력하세요" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-4 control-label"></label>
					<div class="col-sm-5">
						<label id="chk">확인</label>
					</div>
				</div>
				
				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
						<input type="submit"  class="btn btn-success" value="비밀번호 변경" />
						<a href="/mvc" class="btn btn-info">취소</a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	
	<script src="resources/js/jquery-1.9.1.min.js"></script>
	<script>
		$(function(){
			$('#pw2').keyup(function(event){
				var pw1 = $('#pw1').val();
				var pw2 = $('#pw2').val();
				if(pw1.length > 0){
					if(pw1 == pw2){
						$('#chk').text('일치');
					}
					else{
						$('#chk').text('불일치');
					}
				}
				else{
					$('#chk').text('확인');
				}
			});
		});
	</script>
	
</body>
</html>
