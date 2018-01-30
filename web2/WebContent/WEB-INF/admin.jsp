<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자메뉴</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>
<body>
	<div class="w3-container" style="padding:30px">
		<div>
			<a href="admin.do?menu=1" class="w3-button w3-blue w3-round">회원관리</a>
			<a href="admin.do?menu=2" class="w3-button w3-green w3-round">게시글목록</a>
			<a href="admin.do?menu=3" class="w3-button w3-teal w3-round">메뉴3</a>
			<a href="index.do" class="w3-button w3-indigo w3-round w3-right">메인</a>
		</div>
		<hr />
		<div class="w3-container">
			<c:if test="${param.menu == 1 }">
				<table class="w3-table w3-bordered">
					<tr>
						<th><input type="checkbox" id="checkall"/></th>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>주소</th>
						<th>이메일</th>
						<th>가입일</th>
					</tr>
					
					<c:forEach var="vo" items="${list}">
					<tr>
						<td><input type="checkbox" name="checkcls[]" class="checkcls" value=""/></td>
						<td>${vo.id}</td>
						<td>${vo.name}</td>
						<td>${vo.tel}</td>
						<td>[${vo.postcode}] ${vo.addr1} ${vo.addr2}</td>
						<td>${vo.email}</td>
						<td>
							<c:set var="arr" value="${fn:split(vo.joindate,' ')}" />
							${arr[0]}
						</td>
					</tr>	
					</c:forEach>	
				</table>
			</c:if>
			
			<c:if test="${param.menu == 2 }">
				<table class="w3-table w3-bordered">
					<tr>
						<th><input type="checkbox" id="checkall"/></th>
						<th>번호</th>
						<th>글제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>
					
					<c:forEach var="bvo" items="${list}">
					<tr>
						<td><input type="checkbox" name="checkcls[]" class="checkcls" value=""/></td>
						<td>${bvo.no}</td>
						<td>${bvo.title}</td>
						<td>${bvo.writer}</td>
						<td>${bvo.hit}</td>
						<td>${bvo.writedate}</td>
					</tr>	
					</c:forEach>	
				</table>
			</c:if>
			
			<c:if test="${param.menu == 3 }">
				
			</c:if>
		</div>
	
	</div>
	
	<script src="js/jquery-1.9.1.min.js"></script>
	<script>
		$(function(){
			$('#checkall').click(function(){
				if($('#checkall').is(':checked')){
					$('.checkcls').prop('checked', true);
				}
				else{
					$('.checkcls').prop('checked', false);
				}	
			});
		});
	</script>
	
</body>
</html>