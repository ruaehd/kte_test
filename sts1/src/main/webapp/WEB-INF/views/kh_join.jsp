<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>v1_join</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:600px; padding:30px 0; margin:0 auto">
			<form id="form">
				<h3>회원가입</h3>
				<hr />
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">아이디</label>
					<input type="text" style="width:200px" name="id" id="id" class="form-control" />
					<input type="button" class="btn btn-danger" name="id_chk" id="id_chk" value="중복확인" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">비밀번호</label>
					<input type="password" style="width:300px" name="pw" id="pw" class="form-control" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px"></label>
					<input type="password" style="width:300px" name="pw1" id="pw1" class="form-control" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">이름</label>
					<input type="text" style="width:300px" name="name" id="name" class="form-control" />
				</div>
					<div class="form-group">
						<div class="form-inline" style="margin-bottom:10px">
							<label style="width:100px">전화번호</label>
							<select class="form-control" name="tel1" id="tel1">
								<option>선택</option>
								<option>010</option>
								<option>011</option>
							</select>
							<label>-</label>
							<input type="text" style="width:80px" name="tel2" id="tel2" class="form-control" />
							<label>-</label>
							<input type="text" style="width:80px" name="tel3" id="tel3" class="form-control" />
							<input type="hidden" name="tel" />
						</div>
					</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">주소</label>
					<input type="text" name="postcode" class="form-control" id="sample6_postcode" readonly/>
					<input type="button" class="btn btn-danger" onclick="sample6_execDaumPostcode()" name="post_sea" id="post_sea" value="검색" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px"></label>
					<input type="text" style="width:300px" name="addr1" id="sample6_address" class="form-control" readonly/>
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px"></label>
					<input type="text" style="width:300px" name="addr2" id="sample6_address2" class="form-control" />
				</div>

				
				<hr />
				<div align="right">
					<input type="submit" class="btn btn-success" value="회원가입" />
					<a href="#"><input type="button" class="btn btn-info" value="취소" /></a>
				</div>
			</form>
		</div>
	</div>
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="resources/js/additional-methods.min.js"></script>
	<script type="text/javascript" src="resources/js/localization/messages_ko.min.js"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	
	<script>
		$(function(){
			$('#form').validate({
						
				groups: {
					username: "tel1 tel2 tel3",
				},

				errorPlacement: function(error, element) {
					if (element.attr("name") == "tel1" || element.attr("name") == "tel2" || element.attr("name") == "tel3"){
						error.insertAfter("#tel3");
					}
					else{
						 error.insertAfter(element);
					}
				        
				 },
				

				submitHandler : function(){
					var f = confirm("회원가입을 하시겠습니까?");
					if(f){
						return true;
					} else{
						return false;
					}	
				},
				rules:{
					id:{
						required : true,
						minlength : 5,
						remote : 'idcheck.do?'
					},
					pw:{
						required : true,
						minlength : 5
					},
					pw1:{
						required : true,
						minlength : 5,
						equalTo : pw
					},
					name:{
						required : true
					},
					tel1:{
						required : true,
						digits : true
					},
					tel2:{
						required : true,
						digits : true
					},
					tel3:{
						required : true,
						digits : true
					},
					postcode:{
						required : true,
						digits : true
					},
					addr1:{
						required : true
					},
					addr2:{
						required : true
					}
				},
				messages:{
					id:{
						required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다',
						minlength : '&nbsp&nbsp&nbsp'+'5자 이상 입력하세요',
						remote : 'idcheck.do?'
					},
					pw:{
						required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다',
						minlength : '5자 이상 입력하세요'
					},
					pw1:{
						required :'&nbsp&nbsp&nbsp'+'필수입력항목 입니다',
						minlength : '&nbsp&nbsp&nbsp'+'5자 이상 입력하세요',
						equalTo : '&nbsp&nbsp&nbsp'+'비밀번호가 일치하지 않습니다'
					},
					name:{
						required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다'
					},
					tel1:{
						required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다',
						digits : '&nbsp&nbsp&nbsp'+'숫자만 입력가능합니다'
					},
					tel2:{
						required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다',
						digits : '&nbsp&nbsp&nbsp'+'숫자만 입력가능합니다'
					},
					tel3:{
						required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다',
						digits : '숫자만 입력가능합니다'
					},
					postcode:{
						required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다',
						digits : true
					},
					addr1:{
						required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다'
					},
					addr2:{
						required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다'
					}
				}
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
