<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world! 하이하이 
	</h1>
	<a href="">홈</a>
	<c:if test="${sessionScope._email eq null}">
		<a href="memberlogin.do">로그인</a>
		<a href="join.do">회원가입</a>
	</c:if>
	<c:if test="${sessionScope._email ne null}">
		${sessionScope._name}님 로그인
		<a href="edit.do">회원정보 수정</a>
		<a href="memberchangepw.do">비밀번호 변경</a>
		<a href="delete.do">회원탈퇴</a>
		<a href="memberlogout.do">로그아웃</a>
	</c:if>
	<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
