<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:800px; padding:30px 0; margin:0 auto">
			<form action="login.do" method="post" class="form-horizontal">
				<h3>회원가입</h3>
				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-4 control-label" for="email">Email</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="email" name="email" placeholder="이메일 주소를 입력하세요" />
					</div>
				</div><div class="form-group">
					<label class="col-sm-4 control-label" for="pw">비밀번호</label>
					<div class="col-sm-5">
						<input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력하세요" />
					</div>
				</div>
				
				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
						<input type="submit" class="btn btn-success" value="로그인" />
						<a href="join.do"><input type="button" class="btn btn-info" value="회원가입" /></a>
					</div>
				</div>
				
			</form>
		</div>
	</div>

</body>
</html>