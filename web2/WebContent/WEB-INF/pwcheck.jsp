<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 확인</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>
<body>
	
	<div class="w3-container" style="padding:30px">
		<form action="pwcheck.do" method="post">
			<div style="width:600px; margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>비밀번호 확인</h3>
				<hr />
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>아이디</p>
					</div>
					<div class="w3-rest">
						<input type="text" name="id" class="w3-input w3-border w3-round"  style="width:300px" value="${_id}" readonly/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>비밀번호</p>
					</div>
					<div class="w3-rest">
						<input type="password" name="pw" class="w3-input w3-border w3-round" placeholder="비밀번호를 입력하세요." style="width:300px"/>
					</div>
				</div>				
				
				<hr />
				
				<div align="right">
					<input type="submit" class="w3-button w3-blue w3-round" value="확인"/>
					<a href="index.do"><button type="button" class="w3-button w3-green w3-round">취소</button></a>
				</div>		
			</div>
		</form>
	</div>

	
</body>
</html>