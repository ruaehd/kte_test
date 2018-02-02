<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>회원등록</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<form:form action="v1_join.do" modelAttribute="mvo" method="post" id="form">
			아이디 <form:input type="text" id="id" path="no" placeholder="아이디" autofocus="autofocus" /><br />
			암호 	<form:input type="password" id="pw" path="pw" placeholder="암호" /><br />
			암호1	<input type="password" id="pw1" name="pw1" placeholder="암호1" /><br />
			이름 	<input type="text" id="name" name="name" placeholder="이름" /><br />
			생년월일 <input type="text" id="birth" name="birth" placeholder="생년월일(숫자만)"/><br /> 
			전화번호 <input type="text" id="tel" name="tel" /><br /> 
			휴대폰 <input type="text" id="phone" name="phone" /><br /> 
			우편번호<input type="text" id="postcode" name="postcode" /><br /> 
			주소	<input type="text" id="addr" name="addr" /><br /> 
			<input type="submit" value="등록" />
		</form:form>
	</div>
</body>
</html>
