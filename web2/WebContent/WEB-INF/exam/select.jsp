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
		<div style="width:1000px; margin:0px auto; border:solid 1px #ccc; padding:30px">
			<h3>회원 조회 결과</h3>
			<hr />
			
			<table class="w3-table w3-bordered">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>출생년도</th>
					<th>지역</th>
					<th>국번</th>
					<th>전화번호</th>
					<th>키</th>
					<th>가입일</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.userID}</td>
						<td>${vo.name}</td>
						<td>${vo.birthYear}</td>
						<td>${vo.addr}</td>
						<td>${vo.mobile1}</td>
						<td>${vo.mobile2}</td>
						<td>${vo.height}</td>
						<td>${vo.mDATE}</td>
						<td><a href="update.do?userID=${vo.userID}">수정</a></td>
						<td><a href="delete.do?userID=${vo.userID}">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
			<hr />
			<div class="w3-row">
				<a href="main.do">초기화면</a>
			</div>
				
		</div>
	</div>
	
</body>
</html>