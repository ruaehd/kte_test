<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>v9_로그인</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<div class="row" style="margin-top:20px">
			<div class="col-md-6" style="border-right:0px solid #cccccc">
				<div style="width:400px;margin:0 auto;">
				<h4>로그인</h4>
				<hr />
				<form:form action="v9_customerlogin.do" method="post" modelAttribute="vo">
					<div class="form-inline" style="margin-bottom:5px">	
						<label style="width:100px">아이디</label>
						<form:input type="text" path="id" class="form-control" placeholder="아이디" />
					</div>
					
					<div class="form-inline" style="margin-bottom:5px">	
						<label style="width:100px">암호</label>
						<form:input type="password" path="pw" class="form-control" placeholder="암호" />
					</div>
					<div align="right" style="margin-top:30px">
						<input type="submit" class="btn btn-success" value="로그인" />
						<a href="v9_main.do" class="btn btn-default">메인</a>
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
		});
	</script>	
</body>
</html>
