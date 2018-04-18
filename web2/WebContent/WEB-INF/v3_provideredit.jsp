<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공급업체 수정</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>

<body>
	<div class="w3-container" style="padding:30px">
		<form action="v3_provideredit.do" method="post">
			<div style="margin:50px auto; border:solid 1px #ccc; padding:30px">
				<h3>공급업체 수정</h3>
				<hr />
				<table class="w3-table">
					<tr>
						<th>업체코드</th>
						<th>업체명</th>
						<th>대표전화</th>
						<th>담당자</th>
						<th>담당자 핸드폰</th>
						<th>우편번호</th>
						<th>주소</th>
					</tr>
					<tr>
						<td><input type="text" name="code" value="${vo.code}" readonly/></td>
						<td><input type="text" name="name" value="${vo.name}" /></td>
						<td><input type="text" name="tel" value="${vo.tel}" /></td>
						<td><input type="text" name="header" value="${vo.header}" /></td>
						<td><input type="text" name="phone" value="${vo.phone}" /></td>
						<td><input type="text" name="postcode" value="${vo.postcode}" /></td>
						<td><input type="text" name="addr" value="${vo.addr}"/></td>
					</tr>
				</table>
			
				<hr />			
				<div align="right">
					<input type="submit" class="w3-button w3-green w3-round" value="수정"/>
					
				</div>
					
			</div>
		</form>
		
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="js/sweetalert.min.js"></script>
	
	<script>
		$(function(){
			
		
			
		});
	</script>		

</body>
</html>