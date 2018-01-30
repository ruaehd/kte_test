<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet" href="css/w3.css" />
</head>
<body>
	<div style="padding:30px">
		<c:if test="${sessionScope._id eq null}">
			<a href="v2_custominsert.do" class="w3-button w3-black w3-round">회원가입</a>
			<a href="#" class="w3-button w3-black w3-round">로그인</a>
		</c:if>
		
		<c:if test="${sessionScope._id ne null}">
			<label>${sessionScope._name}님 환영합니다.</label>
			<c:if test="${sessionScope._grade == 999}">
				<a href="#" class="w3-button w3-indigo w3-round">관리자메뉴</a>
			</c:if>
			
			<c:if test="${sessionScope._grade == 1}">
				<a href="#" class="w3-button w3-teal w3-round">회원정보 수정</a>
				<a href="#" class="w3-button w3-red w3-round">비밀번호 변경</a>
			</c:if>
				<a href="#" class="w3-button w3-blue w3-round">로그아웃</a>
		</c:if>
		
		<a href="#" class="w3-button w3-green w3-round">게시판</a>
		
	</div>
	
</body>
</html>