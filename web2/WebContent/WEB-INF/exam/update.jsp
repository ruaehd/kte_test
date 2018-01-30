<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>localhost</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>
<body>
	<div class="w3-container" style="padding:30px">
		<form action="update.do" method="post">
			<div style="width:1000px; margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>회원 정보 수정</h3>
				<hr />
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>아이디 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="id" class="w3-input w3-border w3-round" style="width:300px" value="${vo.userID}" readonly/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>이름 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="name" class="w3-input w3-border w3-round" value="${vo.name}" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>출생년도 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="birth" class="w3-input w3-border w3-round" value="${vo.birthYear}" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>지역 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="addr" class="w3-input w3-border w3-round" value="${vo.addr}" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>휴대폰 국번 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="tel1" class="w3-input w3-border w3-round" value="${vo.mobile1}" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>휴대폰 전화번호 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="tel2" class="w3-input w3-border w3-round" value="${vo.mobile2}" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>신장 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="height" class="w3-input w3-border w3-round" value="${vo.height}" style="width:300px"/>
					</div>
				</div>
				
				<hr />
				
				<div align="right">
					<input type="submit" class="w3-button w3-blue w3-round" value="정보 수정"/>
				</div>
				<div align="right">
					<a href="main.do">초기화면</a>
				</div>
			</div>
		</form>
	</div>
	
	
	
</body>
</html>