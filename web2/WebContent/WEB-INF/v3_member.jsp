<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>

<body>
	<div class="w3-container" style="padding:30px">
		<form action="v3_member.do" method="post">
			<div style="margin:0px auto; padding:10px" align="right">
				<div>
					<a href="v3_provider.do" class="w3-button w3-blue w3-round" >공급업체</a>
					<a href="v3_product.do" class="w3-button w3-green w3-round" >상품</a>
					<a href="v3_delivery.do" class="w3-button w3-indigo w3-round" >납품</a>
					<a href="v3_member.do" class="w3-button w3-red w3-round" >회원</a>
					<a href="v3_sale.do" class="w3-button w3-teal w3-round" >판매</a>
					<c:if test="${sessionScope._no eq null}">
						<a href="v3_login.do" class="w3-button w3-black w3-round">로그인</a>
					</c:if>
					<c:if test="${sessionScope._no ne null}">
						<a href="v3_logout.do" class="w3-button w3-black w3-round">로그아웃</a>
					</c:if>
				</div>
			</div>
			
			<div style="margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>회원</h3>
				<hr />
				<table class="w3-table">
					<tr>
						<th>회원번호</th>
						<th>회원이름</th>
						<th>암호</th>
						<th>생년월일</th>
						<th>전화번호</th>
						<th>핸드폰번호</th>
						<th>우편번호</th>
						<th>주소</th>
					</tr>
					<tr>
						<td><input type="text" name="no" value="${lastno}" readonly/></td>
						<td><input type="text" name="name" /></td>
						<td><input type="password" name="pw" /></td>
						<td><input type="text" name="birth" /></td>
						<td><input type="text" name="tel" /></td>
						<td><input type="text" name="phone" /></td>
						<td><input type="text" name="postcode" /></td>
						<td><input type="text" name="addr" /></td>
					</tr>
				</table>
			
				<hr />			
				<div align="right">
					<input type="submit" class="w3-button w3-green w3-round" value="회원가입"/>
				</div>
					
			</div>
		</form>
		<div style="margin:10px auto; border:solid 1px #ccc; padding:30px">
			<form id="form" action="#" method="post">
				<div align="right">
					<input type="submit" name="btn_edit" id="btn_update_chk" class="w3-button w3-indigo w3-round" value="선택수정"/>
					<input type="button" id="btn_delete_chk" class="w3-button w3-red w3-round" value="선택삭제"/>
				</div>
				
				<table class="w3-table w3-bordered">
					<tr>
						<th><input type="checkbox" id="chk_all" /></th>
						<th>회원번호</th>
						<th>회원이름</th>
						<th>생년월일</th>
						<th>전화번호</th>
						<th>핸드폰번호</th>
						<th>우편번호</th>
						<th>주소</th>
						<th>날짜</th>
						<th>비고</th>
					</tr>
					
					<c:if test="${empty list}">
						<tr>
							<td colspan="10">자료가 없습니다.</td>
						</tr>
					</c:if>
					
					<c:if test="${!empty list}">
						<c:forEach var="vo" items="${list}">
							<tr>
								<td><input type="checkbox" class="chk" name="chk[]" value="" /></td> 
								<td>${vo.no}</td>
								<td>${vo.name}</td>
								<td>${vo.birth}</td>
								<td>${vo.tel}</td>
								<td>${vo.phone}</td>
								<td>${vo.postcode}</td>
								<td>${vo.addr}</td>
								<td>${vo.date1}</td>
								<td>
									<a href="#" class="w3-button w3-tiny w3-blue w3-round" >수정</a>
									<a href="#" class="w3-button w3-tiny w3-red w3-round btn_delete">삭제</a>
								</td>
							</tr>	
						</c:forEach>
					</c:if>
				</table>
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