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
			<h3>회원 관리 시스템</h3>
			<hr />
			
			<div class="w3-row">
				<a href="select.do">(1)회원조회 (조회 후 수정/삭제 가능)</a>
			</div>
			
			<div class="w3-row">
				<div class="w3-col">
					<a href="insert.do">(2)신규 회원 등록</a>
				</div>
			</div>
		
			<div class="w3-row">
				<div class="w3-col" style="width:auto">
					<p>(3)회원 수정 - 회원 아이디 : </p>
				</div>
				<div class="w3-rest">
					<div class="w3-left">
						<input type="text" class="w3-input w3-border w3-round" id="userID" style="width:300px"/>
					</div>
					<div class="w3-left">
						<a href="update.do?userID=" class="w3-button w3-blue w3-round" id="btn_update">수정</a>
					</div>
				</div>
			</div>
			
			<div class="w3-row">
				<div class="w3-col" style="width:auto">
					<p>(4)회원 삭제 - 회원 아이디 : </p>
				</div>
				<div class="w3-rest">
					<div class="w3-left">
						<input type="text" class="w3-input w3-border w3-round" id="userID2" style="width:300px"/>
					</div>
					<div class="w3-left">
						<a href="delete.do?userID=" class="w3-button w3-red w3-round" id="btn_delete">삭제</a>
					</div>
				</div>
			</div>
				
		</div>
	</div>
	
	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="js/sweetalert.min.js"></script>
	<script>
		$(function(){
			$('#btn_update').click(function(){
				var href = $(this).attr('href');
				var id = $('#userID').val();
			
				$(this).attr('href', href+id);
			});	
			
			$('#btn_delete').click(function(){
				var href = $(this).attr('href');
				var id = $('#userID2').val();
			
				$(this).attr('href', href+id);
			});
		});
	</script>
	
	
</body>
</html>