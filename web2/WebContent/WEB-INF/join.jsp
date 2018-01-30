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
		<form action="join.do" method="post">
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
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>주소</p>
					</div>
					<div class="w3-rest">
						<div class="w3-left">				
							<input type="text" class="w3-input w3-border w3-round" id="sample6_postcode" name="postcode" style="width:100px" placeholder="우편번호" readonly/>
						</div>
						<div class="w3-left" style="margin-left:5px">
							<button class="w3-button w3-khaki w3-round" type="button" onclick="sample6_execDaumPostcode()">찾기</button>
						</div>	
							<input type="text" class="w3-input w3-border w3-round" id="sample6_address" name="addr1" placeholder="주소" readonly/>
							<input type="text" class="w3-input w3-border w3-round" id="sample6_address2" name="addr2" placeholder="상세주소"/>				
					</div>
				</div>
					
				<div class="w3-row" style="margin-top:10px">
					<div class="w3-col" style="width:100px">
						<p>이메일주소</p>
					</div>
					<div class="w3-rest">
						<input type="text" class="w3-input w3-border w3-round" id="email" name="email" placeholder="이메일 주소를 입력하세요."/>
					</div>
				</div>	
				
				<hr />
				
				<div align="right">
					<input type="submit" id="btn_submit" class="w3-button w3-blue w3-round" value="회원가입"/>
					<a href="index.do"><button type="button" class="w3-button w3-green w3-round">취소</button></a>
				</div>
					
			</div>
		</form>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		$(function(){
			$('#id').keyup(function(){
				//아이디 값을 받아옴
				var a = $('#id').val();
				
				if(a.length>0){
					//비동기로 서버 호출
					$.get('jsonmember.do?id='+a, function(data){
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
				
				console.log(p1+","+p2);
				
				
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
				var h =$('#sample6_postcode').val();
				var i =$('#sample6_address').val();
				var j =$('#sample6_address2').val();
				var k =$('#email').val();
				
				var p1 = $('#pw').val();
				var p2 = $('#pw1').val();
				
				if(a==''){	//a가 비어 있다면
					alert("아이디를 입력하세요");
					$('#id').focus();
					return false;
				}
				if(b==''){	//b가 비어 있다면
					alert("이름을 입력하세요");
					$('#name').focus();
					return false;
				}
				if(c==''){	//c가 비어 있다면
					alert("암호를 입력하세요");
					$('#pw').focus();
					return false;
				}
				if(d==''){	//d가 비어 있다면
					alert("암호를 입력하세요");
					$('#pw1').focus();
					return false;
				}
				if(e==''){	//e가 비어 있다면
					alert("전화번호를 입력하세요");
					$('#tel1').focus();
					return false;
				}
				if(f==''){	//f가 비어 있다면
					alert("전화번호를 입력하세요");
					$('#tel2').focus();
					return false;
				}
				if(g==''){	//g가 비어 있다면
					alert("전화번호를 입력하세요");
					$('#tel3').focus();
					return false;
				}
				if(h==''){	//h가 비어 있다면
					alert("주소를 입력하세요");
					$('#sample6_postcode').focus();
					return false;
				}
				if(i==''){	//i가 비어 있다면
					alert("주소를 입력하세요");
					$('#sample6_address').focus();
					return false;
				}
				if(j==''){	//j가 비어 있다면
					alert("주소를 입력하세요");
					$('#sample6_address2').focus();
					return false;
				}
				if(k==''){	//k가 비어 있다면
					alert("email주소를 입력하세요");
					$('#email').focus();
					return false;
				}
				if(p1!=p2){
					alert("암호가 일치하지 않습니다.");
					$('#pw1').focus();
					return false;
				}
				
				alert("가입이 완료되었습니다.");
				
			})
		});
		
	
	    function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullAddr = ''; // 최종 주소 변수
	                var extraAddr = ''; // 조합형 주소 변수
	
	                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    fullAddr = data.roadAddress;
	
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    fullAddr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
	                if(data.userSelectedType === 'R'){
	                    //법정동명이 있을 경우 추가한다.
	                    if(data.bname !== ''){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있을 경우 추가한다.
	                    if(data.buildingName !== ''){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
	                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('sample6_address').value = fullAddr;
	
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById('sample6_address2').focus();
	            }
	        }).open();
	    }
	</script>		

</body>
</html>