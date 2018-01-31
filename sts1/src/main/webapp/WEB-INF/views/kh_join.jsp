<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원가입</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:800px; padding:10px 50px; margin:10px auto; border:solid 1px #ccc" >
			<form action="#" method="#" id="form">
				<h3>회원가입</h3>
				<hr />
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">아이디</label>
					<input type="text" name="id" id="id" style="width:38%" class="form-control" placeholder="아이디를 입력하세요" />
					<a href="#"><input type="button" class="btn btn-danger" value="중복확인"></a>
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">비밀번호</label>
					<input type="password" name="pw" id="pw" style="width:50%" class="form-control" placeholder="비밀번호를 입력하세요" />
				</div>
				<div class="form-inline" >
					<label style="width:100px"></label>
					<input type="password" name="pw1" id="pw1" style="width:50%" class="form-control" placeholder="비밀번호를 다시 입력하세요" />
				</div>
				<div class="form-inline" style="margin-bottom:10px" style="margin-top:10px">
					<label style="width:100px"></label>
					<label id="chkpw"></label>
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">이름</label>
					<input type="text" name="name" id="name" style="width:50%" class="form-control" placeholder="이름을 입력하세요" />
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">전화번호</label>
					<select class="form-control" style="width:100px" id="tel1" name="tel1">
						<option>선택</option>
						<option>010</option>
						<option>011</option>
					</select>
					<label>-</label>
					<input type="text" style="width:100px" name="tel2" id="tel2" class="form-control"/>
					<label>-</label>
					<input type="text" style="width:100px" name="tel3" id="tel3" class="form-control"/>
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">주소</label>
					<input type="text" name="addr1" id="sample6_postcode" name="postcode" style="width:25%" class="form-control" placeholder="우편번호"  readonly/>
					<a href="#"><input type="button" class="btn btn-success" onclick="sample6_execDaumPostcode()" value="검색"></a>
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px"></label>	
					<input type="text" name="addr2" id="sample6_address" name="addr1" style="width:50%" class="form-control" placeholder="상세주소1" readonly/>
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px"></label>
					<input type="text" name="addr3" id="sample6_address2" name="addr2" style="width:50%" class="form-control" placeholder="상세주소2" />
				</div>
				<hr />
				<div class="form-inline" style="margin-bottom:10px" align="right">
					<input type="submit" class="btn btn-success" value="회원가입" />
					<a href="#"><input type="button" class="btn btn-info" value="취소" id="btn_submit"></a>
				</div>
			</form>
		</div>
	</div>
	
	<script src="resources/js/jquery-1.9.1.min.js"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="resources/js/additional-methods.min.js"></script>
	<script type="text/javascript" src="resources/js/localization/messages_ko.min.js"></script>
	
	<script>
		$(function(){

			$('#form').validate({
				/* 
				required : true => 비어있는지 확인
				digits : true => 숫자만 가능
				minlength : 5 => 최소길이 5자이상
				email : true => 이메일 형식만 가능(ex abc@naver.com)
				agree : "required" => 체크박스에 체크가 되어야함 
				*/
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
						digits : true
					},
					tel2:{
						digits : true
					},
					tel3:{
						digits : true
					},
					postcode:{
						required : true,
						minlength : 5
					},
					addr1:{
						required : true,
						minlength : 5
					},
					addr2:{
						required : true,
						minlength : 5
					}
				},
				messages:{
					id:{
						required : '내용이 없습니다',
						minlength : '5자이상 입력하세요',
						remote : '아이디가 중복입니다'
					},
					pw:{
						required : '내용이 없습니다',
						minlength : '5자이상 입력하세요'
					},
					pw1:{
						required : '내용이 없습니다',
						minlength : '5자이상 입력하세요',
						equalTo : '암호가 일치하지 않습니다'
					},
					name:{
						required : '내용이 없습니다'
					},
					tel1:{
						digits : '숫자만 입력 가능합니다'
					},
					tel2:{
						digits : '숫자만 입력 가능합니다'
					},
					tel3:{
						digits : '숫자만 입력 가능합니다'
					},
					postcode:{
						required : '내용이 없습니다'
					},
					addr1:{
						required : '내용이 없습니다'
					},
					addr2:{
						required : '내용이 없습니다'
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