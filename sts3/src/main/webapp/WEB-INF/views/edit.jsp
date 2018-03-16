<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>정보수정</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:800px; padding:30px 0; margin:0 auto">
			<form:form action="edit.do" modelAttribute="vo" method="post" class="form-horizontal">
				<h3>정보수정</h3>
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
					<label class="col-sm-4 control-label" for="name">이름</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="name" path="name" value="${vo.name}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="phone">전화번호</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="phone" path="phone" value="${vo.phone}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="post_code">우편번호</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="post_code" path="post_code" value="${vo.post_code}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="addr1">상세주소1</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="addr1" path="addr1" value="${vo.addr1}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="addr2">상세주소2</label>
					<div class="col-sm-5">
						<form:input type="text" class="form-control" id="addr2" path="addr2" value="${vo.addr2}"/>
					</div>
				</div>

				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
						<input type="submit" class="btn btn-success" value="수정" />
						<a href="/mvc" class="btn btn-info">취소</a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
