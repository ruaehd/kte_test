<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>회원수정</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<form:form action="v1_edit.do" modelAttribute="mvo" method="post" id="form">
			아이디 <form:input type="text" id="id" path="no" placeholder="아이디" autofocus="autofocus" /><br />
			이름 	<form:input type="text" id="name" path="name" placeholder="이름" /><br />
			생년월일 <form:input type="text" id="birth" path="birth" placeholder="생년월일(숫자만)"/><br /> 
			전화번호 <form:input type="text" id="tel" path="tel" /><br /> 
			휴대폰 <form:input type="text" id="phone" path="phone" /><br /> 
			우편번호<form:input type="text" id="postcode" path="postcode" /><br /> 
			주소	<form:input type="text" id="addr" path="addr" /><br /> 
			가입일 <form:input type="text" id="date1" path="date1" readonly="true" /><br />
			<input type="submit" value="수정" />
		</form:form>
	</div>
</body>
</html>
