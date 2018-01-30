<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>내용</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<div style="width: 1000px; border: 1px solid #ccc; padding:30px; margin: 30px auto;">
			<h3>내용</h3>
			<hr />
			<table class="table">
				<tr>
					<th style="width:10%">제목</th>
					<td style="width:40%">${vo.title}</td>
					<th style="width:10%">조회수</th>
					<td style="width:40%">${vo.hit}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${vo.writer}</td>
					<th>날짜</th>
					<td>${vo.date1}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">${vo.content}</td>
				</tr>
			</table>
			<hr />
			<div align="right">
				<c:if test="${prev !=0}">
					<a href="v3_boardqnacontent.do?no=${prev}" class="btn btn-primary">이전글</a>
				</c:if>
				<%-- <c:if test="${prev ==0}">
					<a href="#" class="btn btn-primary" disabled>이전글</a>
				</c:if> --%>
				
				<a href="v3_boardqna.do" class="btn btn-info">목록</a>
				
				<c:if test="${next !=0}">
					<a href="v3_boardqnacontent.do?no=${next}" class="btn btn-success">다음글</a>
				</c:if>
			</div>
		</div>
	</div>
	
	<script src="js/jquery-1.9.1.min.js"></script>
	<script>
		$(function(){
			
			var wsconn = new WebSocket("ws://127.0.0.1/web2/wsserver");
			
			wsconn.onerror = function(event){
				console.log('error - '+event.data+'\n');
			};
			
			wsconn.onopen = function(event){
				console.log('connected - '+'\n');
				
				var msg = {"no":'${vo.no}', "hit":'${vo.hit}'};	//=> JSONobject
				wsconn.send(JSON.stringify(msg));	//JSON => String
			};
			
		});
	</script>
</body>
</html>