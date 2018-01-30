<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>선택수정</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>
<body>

	<div class="w3-container" style="padding:30px">
		<div style="width:1000px; margin:0px auto; border:solid 1px #ccc; padding:30px">
			<h3>물품수정</h3>
			<hr />
			<form action="v2_itemupdate1.do" method="post">
				<table class="w3-table w3-bordered">
					<tr>
						<th>물품번호</th>
						<th>물품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>등록일</th>
					</tr>
					
					<c:forEach var="vo" items="${list}">
						<tr>
							<td><input type="hidden" name="no[]" id="no" value="${vo.no}" />${vo.no}</td>
							<td><input type="text" name="name[]" id="name" value="${vo.name}" /></td>
							<td><input type="text" name="price[]" id="price" value="${vo.price}"/></td>
							<td><input type="text" name="qty[]" id="qty" value="${vo.qty}"/></td>
							<td>${vo.date1}</td>
						</tr>
					</c:forEach>
				
				</table>
				<hr />
				<input type="submit" name="btn_edit" id="btn_edit" class="w3-button w3-blue w3-round" value="전체수정"/>
				<a href="#" class="w3-button w3-red w3-round">취소</a>
			</form>
		</div>
	</div>

	
	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="js/sweetalert.min.js"></script>
	
	<script>
		$(function(){
		
		});
	</script>	

</body>
</html>