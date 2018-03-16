<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원가입</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:800px; padding:30px 0; margin:0 auto">
			<form:form action="join.do" modelAttribute="vo" method="post" class="form-horizontal">
				<h3>회원가입</h3>
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
					<label class="col-sm-4 control-label" for="pw1"></label>
					<div class="col-sm-5">
						<input type="password" class="form-control" id="pw1" name="pw1" placeholder="비밀번호를  다시 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="name">이름</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="name" path="name" placeholder="이름을 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="phone">전화번호</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="phone" path="phone" placeholder="전화번호를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="post_code">우편번호</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="post_code" path="post_code" placeholder="우편번호를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="addr1">상세주소1</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="addr1" path="addr1" placeholder="상세주소를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="addr2">상세주소2</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="addr2" path="addr2" placeholder="상세주소를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="ns_name">관심분야</label>
					<div class="col-sm-5">
						<c:forEach var="tmp" items="${vo.ns_name_item}">
							<form:checkbox class="chk" path="ns_name" value="${tmp}" />${tmp}
						</c:forEach>
					</div>
				</div>

				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
						<input type="submit" id="btn_join" class="btn btn-success" value="회원가입" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
	
	<script src="resources/js/jquery-1.9.1.min.js"></script>
	<script>
		$(function(){
			$('#btn_join').click(function(){
				var len = $('.chk:checked').length;
				if(len<=0){
					alert('한개이상 체크하세요');
					return false;
				}
			});
		});
	</script>
	
</body>
</html>
