<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>물품등록</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>

<body>
	<div class="w3-container" style="padding:30px">
		<form action="v2_iteminsert1.do" method="post">
			<div style="width:1000px; margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>물품등록</h3>
				<hr />
				<table class="w3-table">
					<tr>
						<th>물품번호</th>
						<th>물품명</th>
						<th>가격</th>
						<th>수량</th>
					</tr>
					
					<c:forEach var="i" begin="1" end="2" step="1">
					<tr>
						<td><input type="text" name="no[]" value="${lastno+i}" readonly /></td>
						<td><input type="text" name="name[]" /></td>
						<td><input type="text" name="price[]" /></td>
						<td><input type="text" name="qty[]" /></td>
					</tr>
					
					</c:forEach>
					
				</table>
			
				<hr />			
				<div align="right">
					<input type="submit" class="w3-button w3-green w3-round" value="물품등록"/>
				</div>
					
			</div>
		</form>
		<div style="width:1000px; margin:10px auto; border:solid 1px #ccc; padding:30px">
			<form id="form" action="v2_itemdelete.do" method="post">
				<div align="right">
					<input type="button" id="btn_delete_chk" class="w3-button w3-red w3-round" value="선택삭제"/>
				</div>
				
				<table class="w3-table w3-bordered">
					<tr>
						<th><input type="checkbox" id="chk_all" /></th>
						<th>물품번호</th>
						<th>물품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>날짜</th>
						<th>비고</th>
					</tr>
					<c:forEach var="vo" items="${list}" varStatus="i">
						<tr>
							<td><input type="checkbox" class="chk" name="chk[]" value="${vo.no}" /></td> 
							<td id="no_${i.index}">${vo.no}</td>
							<td>${vo.name}</td>
							<td>${vo.price}</td>
							<td>${vo.qty}</td>
							<td>${vo.date1}</td>
							<td>
								<a href="#" class="w3-button w3-tiny w3-blue w3-round">수정</a>
								<a href="#" class="w3-button w3-tiny w3-red w3-round btn_delete">삭제</a>
							</td>
						</tr>	
					</c:forEach>
				</table>
			</form>
		</div>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="js/sweetalert.min.js"></script>
	
	<script>
		$(function(){
			$('.btn_delete').click(function(){
				//class로 지정란 버튼의 위치 얻기(0부터 시작함)
				var idx = $(this).index('.btn_delete');
				var no = $('#no_'+idx).text();
				
				swal({
					title : "삭제확인",
					text : "삭제 하시겠습니까?",
					icon : "info",
					button : "확인"
				}).then((value)=>{
					if(value){
						window.location.href='v2_itemdelete.do?no='+no;	
					}
				});	
			});
			
			$('#chk_all').click(function(){
				if($(this).is(':checked')){	//체크가 된 상태
					$('.chk').prop('checked', true);
				}
				else{	//체크를 푼 상태
					$('.chk').prop('checked', false);
				}
			});
			
			$('#btn_delete_chk').click(function(){
				var n = $('.chk:checked').length;
				if(n>0){
					swal({
						title : "삭제확인",
						text : "선택된 항목을 삭제 하시겠습니까?",
						icon : "warning",
						button : "확인"
					}).then((value)=>{
						if(value){
							$('#form').submit();
						}
					});	
				}
				else{
					swal('선택된 항목이 없습니다.');	
				}	
			});
			
			
			
		});
	</script>		

</body>
</html>