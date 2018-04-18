<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원정보 수정</title>
	<link rel="stylesheet" href="css/w3.css" />
</head>
<body>
<div class="w3-container" style="padding:30px">
		<form action="edit.do" method="post">
			<div style="width:600px; margin:0px auto; border:solid 1px #ccc; padding:30px">
				<h3>회원정보 수정</h3>
				<hr />
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>아이디</p>
					</div>
					<div class="w3-rest">
						<input type="text" id="id" name="id" class="w3-input w3-border w3-round" value="${vo.id}" readonly/>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>이름</p>
					</div>
					<div class="w3-rest">
						<input type="text" id="name" name="name" class="w3-input w3-border w3-round" value="${vo.name}" />
					</div>
				</div>
											
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>휴대폰</p>
					</div>
					<div class="w3-rest">
						<div class="w3-left">
							<input type="text" class="w3-input w3-border w3-round" style="width:100px" name="tel1" id="tel1" value="${vo.tel1}"/>
						</div>	
						<div class="w3-left" style="margin-left:5px">
							<input type="text" class="w3-input w3-border w3-round" style="width:100px" name="tel2" id="tel2" value="${vo.tel2}"/>
						</div>
						<div class="w3-left" style="margin-left:5px">
							<input type="text" class="w3-input w3-border w3-round" style="width:100px" name="tel3" id="tel3" value="${vo.tel3}"/>
						</div>
					</div>
				</div>
				
				<div class="w3-row">
					<div class="w3-col" style="width:100px">
						<p>주소</p>
					</div>
					<div class="w3-rest">
						<div class="w3-left">				
							<input type="text" class="w3-input w3-border w3-round" id="sample6_postcode" name="postcode" style="width:100px" value="${vo.postcode}" readonly/>
						</div>
						<div class="w3-left" style="margin-left:5px">
							<button class="w3-button w3-khaki w3-round" type="button" onclick="sample6_execDaumPostcode()">찾기</button>
						</div>	
							<input type="text" class="w3-input w3-border w3-round" id="sample6_address" name="addr1" value="${vo.addr1}" readonly/>
							<input type="text" class="w3-input w3-border w3-round" id="sample6_address2" name="addr2" value="${vo.addr2}" />				
					</div>
				</div>
					
				<div class="w3-row" style="margin-top:10px">
					<div class="w3-col" style="width:100px">
						<p>이메일주소</p>
					</div>
					<div class="w3-rest">
						<input type="text" class="w3-input w3-border w3-round" id="email" name="email" value="${vo.email}" />
					</div>
				</div>	
				
				<hr />
				
				<div align="right">
					<input type="submit" id="btn_edit" class="w3-button w3-blue w3-round" value="정보수정"/>
					<a href="index.do"><button type="button" class="w3-button w3-green w3-round">취소</button></a>
				</div>
					
			</div>
		</form>
	</div>
	
	<script src="js/jquery-1.9.1.min.js"></script>		
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		$(function(){
			
		$(document).ready(function(){
			$('#btn_edit').click(function(){	//btn이 클릭되면

				var b =$('#name').val();	//id가 pw인 태그의 값

				var e =$('#tel1').val();
				var f =$('#tel2').val();
				var g =$('#tel3').val();
				var h =$('#sample6_postcode').val();
				var i =$('#sample6_address').val();
				var j =$('#sample6_address2').val();
				var k =$('#email').val();

				
				if(b==''){	//b가 비어 있다면
					alert("이름을 입력하세요");
					$('#name').focus();
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
				
				
				alert("수정이 완료되었습니다.");
				
			})
		});
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