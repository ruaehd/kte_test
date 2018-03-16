<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원 정보삭제</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:800px; padding:30px 0; margin:0 auto">
			<form:form action="delete.do" modelAttribute="vo" method="post" class="form-horizontal">
				<h3>회원 정보삭제</h3>
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
					<label class="col-sm-4 control-label" for="pw">비밀번호</label>
					<div class="col-sm-5">
						<form:input type="password" class="form-control" id="pw" path="pw" placeholder="비밀번호를 입력하세요" />
					</div>
				</div>

				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
						<input type="submit" class="btn btn-success" value="삭제" />
						<a href="/mvc" class="btn btn-info">취소</a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
