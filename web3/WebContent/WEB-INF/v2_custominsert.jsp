<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>

<body>
	<div class="w3-container" style="padding:30px">
		<form action="v2_custominsert.do" method="post">
			<div style="width:600px; margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>회원가입</h3>
				<hr />
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>아이디</p>
					</div>
					<div class="w3-rest">
						<div class="w3-left">
							<input type="text" id="id" name="id" class="w3-input w3-border w3-round" placeholder="아이디를 입력하세요." style="width:300px"/>
						</div>
						<div class="w3-left" style="margin-left:5px">
							<button class="w3-button w3-khaki w3-round" type="button" id="btn_idcheck">중복확인</button>
						</div>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>이름</p>
					</div>
					<div class="w3-rest">
						<input type="text" id="name" name="name" class="w3-input w3-border w3-round" placeholder="이름을 입력하세요."/>
					</div>
				</div>
							
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>암호</p>
					</div>
					<div class="w3-rest">
						<input type="password" name="pw" class="w3-input w3-border w3-round" id="pw" placeholder="비밀번호를 입력하세요."/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p></p>
					</div>
					<div class="w3-rest">
						<input type="password" class="w3-input w3-border w3-round" id="pw1" placeholder="비밀번호를 다시 입력하세요."/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
					<p></p>
					</div>
					<div class="w3-rest">
						<p id="chkpw"></p>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>휴대폰</p>
					</div>
					<div class="w3-rest">
						<div class="w3-left">
							<input type="text" class="w3-input w3-border w3-round" style="width:100px" placeholder="000" name="tel1" id="tel1" />
						</div>	
						<div class="w3-left" style="margin-left:5px">
							<input type="text" class="w3-input w3-border w3-round" style="width:100px" placeholder="0000" name="tel2" id="tel2" />
						</div>
						<div class="w3-left" style="margin-left:5px">
							<input type="text" class="w3-input w3-border w3-round" style="width:100px" placeholder="0000" name="tel3" id="tel3" />
						</div>
					</div>
				</div>
				
				<hr />
				
				<div align="right">
					<input type="submit" id="btn_submit" class="w3-button w3-blue w3-round" value="회원가입"/>
					<a href="v2_index.do"><button type="button" class="w3-button w3-green w3-round">취소</button></a>
				</div>
					
			</div>
		</form>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="js/sweetalert.min.js"></script>
	
	<script>
		$(function(){
			$('#id').keyup(function(){
				//아이디 값을 받아옴
				var a = $('#id').val();	
				
				if(a.length>0){
					//비동기로 서버 호출
					$.post('v2_jsonmember.do',{'id':a}, function(data){		//post방식
					/* $.get('v2_jsonmember.do?id='+a, function(data){ */	//get방식
						if(data.result == 0){
							$('#btn_idcheck').text('사용가능');	
						}
						else if(data.result == 1){
							$('#btn_idcheck').text('사용불가');
						}
					},'json');
				}
				else{
					$('#btn_idcheck').text('중복확인');
				}
			});
			
			//태그 중에서  id가 pw1인 것에 키보드 값이 입력되면
			$('#pw1').keyup(function(){
				//태그중에 id가 pw인 값을 가져옴
				var p1 = $('#pw').val();
				//태그중에 id가 pw1인 값을 가져옴
				var p2 = $('#pw1').val();
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
			$('#btn_submit').click(function(){	//btn이 클릭되면
				var a =$('#id').val();	//id가 id인 태그의  값
				var b =$('#name').val();	//id가 pw인 태그의 값
				var c =$('#pw').val();
				var d =$('#pw1').val();
				var e =$('#tel1').val();
				var f =$('#tel2').val();
				var g =$('#tel3').val();
				
				var p1 = $('#pw').val();
				var p2 = $('#pw1').val();	//input type인 경우
				
				var ic = $('#btn_idcheck').text();	//태그와 태그사이
				
				if(a==''){	//a가 비어 있다면
					swal('아이디를 입력하세요')
					.then((value) => {
						$('#id').focus();	
					});
					return false;
				}
				
				if(b==''){	//b가 비어 있다면
					swal('이름을 입력하세요')
					.then((value) => {
						$('#name').focus();
					});
					return false;
				}
				if(c==''){	//c가 비어 있다면
					swal('암호를 입력하세요')
					.then((value) => {
						$('#pw').focus();
					});
					return false;
				}
				if(d==''){	//d가 비어 있다면
					swal('암호를 입력하세요')
					.then((value) => {
						$('#pw1').focus();
					});
					return false;
				}
				if(e==''){	//e가 비어 있다면
					swal('전화번호를 입력하세요')
					.then((value) => {
						$('#tel1').focus();
					});
					return false;
				}
				if(f==''){	//f가 비어 있다면
					swal('전화번호를 입력하세요')
					.then((value) => {
						$('#tel2').focus();
					});
					return false;
				}
				if(g==''){	//g가 비어 있다면
					swal('전화번호를 입력하세요')
					.then((value) => {
						$('#tel3').focus();
					});
					return false;
				}
				
			/* 	if(ic != '사용가능'){
					swal('아이디 중복확인이 필요합니다.')
					.then((value) => {
						$('#id').focus();
					});
					return false;
				} */
				
				if(p1!=p2){
					swal('암호가 일치하지 않습니다.')
					.then((value) => {
						$('#pw1').focus();
					});
					return false;
				}
				
				/* swal('가입이 완료되었습니다.'); */
			})
		});
		
	</script>		

</body>
</html>