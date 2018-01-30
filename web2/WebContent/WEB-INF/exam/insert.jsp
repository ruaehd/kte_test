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
		<form action="insert.do" method="post">
			<div style="width:1000px; margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>신규 회원 입력</h3>
				<hr />
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>아이디 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="id" class="w3-input w3-border w3-round" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>이름 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="name" class="w3-input w3-border w3-round" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>출생년도 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="birth" class="w3-input w3-border w3-round" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>지역 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="addr" class="w3-input w3-border w3-round" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>휴대폰 국번 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="tel1" class="w3-input w3-border w3-round" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>휴대폰 전화번호 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="tel2" class="w3-input w3-border w3-round" style="width:300px"/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>신장 : </p>
					</div>
					<div class="w3-rest">
						<input type="text" name="height" class="w3-input w3-border w3-round" style="width:300px"/>
					</div>
				</div>
				
				<hr />
				
				<div align="right">
					<input type="submit" class="w3-button w3-blue w3-round" value="회원가입"/>
				</div>
				<div align="right">
					<a href="main.do">초기화면</a>
				</div>
			</div>
		</form>
	</div>
	
	<%-- <form action="insert.do" method="post">
		<c:forEach var="tmp" items="${title}">
			${tmp}<input type="text" name="name[]" value="1" /><br>
		</c:forEach>
	</form> --%>
	
	
</body>
</html>