<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 변경</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>
<body>
	
	<div class="w3-container" style="padding:30px">
		<form action="changepw.do" method="post">
			<div style="width:600px; margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>비밀번호 변경</h3>
				<hr />
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>기존 비밀번호</p>
					</div>
					<div class="w3-rest">
						<input type="password" name="pw" id="pw" class="w3-input w3-border w3-round" placeholder="기존 비밀번호를 입력하세요." />
					</div>
				</div>				
				
				<hr />
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p>새 비밀번호</p>
					</div>
					<div class="w3-rest">
						<input type="password" name="pw1" id="pw1" class="w3-input w3-border w3-round" placeholder="새 비밀번호를 입력하세요." />
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
						<p></p>
					</div>
					<div class="w3-rest">
						<input type="password" name="pw2" id="pw2" class="w3-input w3-border w3-round" placeholder="새 비밀번호를 다시 입력하세요." />
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:150px">
					<p></p>
					</div>
					<div class="w3-rest">
						<p id="chkpw"></p>
					</div>
				</div>
				
				<hr />
				
				<div align="right">
					<input type="submit" id="btn_changepw" class="w3-button w3-blue w3-round" value="변경"/>
					<a href="index.do"><button type="button" class="w3-button w3-green w3-round">취소</button></a>
				</div>		
			</div>
		</form>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script>
		$(function(){
			$('#pw2').keyup(function(){
				//태그중에 id가 pw인 값을 가져옴
				var p1 = $('#pw1').val();
				//태그중에 id가 pw1인 값을 가져옴
				var p2 = $('#pw2').val();
				//화면에 출력함.
				
				if(p1==p2){
					//id가 chkpw인 태그의 내용을 일치함으로
					$('#chkpw').css('color','blue').html('암호가 일치합니다.')
				}
				else{
					$('#chkpw').css('color','red').html('암호가 일치하지 않습니다.')
				}
			});
		});	
		
 		$(document).ready(function(){
			$('#btn_changepw').click(function(){
				var p1 = $('#pw1').val();
				var p2 = $('#pw2').val();
				
				if(p1!=p2){
					alert("새 비밀번호가 일치하지 않습니다.");
					$('#pw2').focus();
					return false;
				}
			})
		});
			
	</script>
		


</body>
</html>