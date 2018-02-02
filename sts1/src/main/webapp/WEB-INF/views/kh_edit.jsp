<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원 정보 수정</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
	<style type="text/css">
		input.error{
		  color:red;
		}
		label.error{
		  color:red;
		}
	</style>
	
</head>
<body>
	<div class="container">
		
		<div style="width:800px; padding:30px 0; margin:0 auto">
			<form id="form"  class="form-horizontal">
				<h3>회원 정보 수정</h3>
				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-4 control-label" for="name">이름</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label" for="tel1">전화번호</label>
					<div class="col-sm-5">
						<div class="form-inline">
							<select class="form-control" name="tel1" id="tel1">
								<option>선택</option>
								<option>010</option>
								<option>011</option>
							</select>
							<label>-</label>
							<input type="text" style="width:80px" name="tel2" id="tel2" class="form-control" />
							<label>-</label>
							<input type="text" style="width:80px" name="tel3" id="tel3" class="form-control" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-4 control-label" for="addr">주소</label>
					<div class="col-sm-5">
						<div class="form-inline post_search">
							<input type="text" name="postcode" class="form-control" id="sample6_postcode" readonly/>
							<input type="button" class="btn btn-danger" onclick="sample6_execDaumPostcode()" name="post_search" id="post_search" value="검색" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-4 control-label" ></label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="sample6_address" name="addr1" placeholder="상세주소1" readonly/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" ></label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="sample6_address2" name="addr2" placeholder="상세주소2" />
					</div>
				</div>

				<div class="form-group">
					<div align="center" class="col-sm-9">
						<hr />
						<input type="submit" class="btn btn-success" value="정보 수정" />
						<a href="#"><input type="button" class="btn btn-info" value="취소" /></a>
					</div>
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
				
				onkeyup: function(element) { $(element).valid(); },
				onfocusout: function(element) { $(element).valid(); },
				
				groups: {
					username: "tel1 tel2 tel3"
				},
				errorPlacement: function(error, element) {
					if (element.attr("name") == "tel1" || element.attr("name") == "tel2" || element.attr("name") == "tel3"){
						error.insertAfter("#tel3");
					}
					else{
						 error.insertAfter(element);
					}

					if (element.attr("name") == "postcode"){
						error.insertAfter(".post_search");
					}

				 },
				
				submitHandler : function(){
					var f = confirm("정보를 수정 하시겠습니까?");
					if(f){
						return true;
					} else{
						return false;
					}	
				},
				rules:{
					name:{ required : true },
					tel1:{ required : true, digits : true },
					tel2:{ required : true, digits : true },
					tel3:{ required : true, digits : true },
					postcode:{ required : true },
					addr1:{ required : true },
					addr2:{ required : true }
				},
				messages:{
					name:{required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다'},
					tel1:{required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다',
						digits : '&nbsp&nbsp&nbsp'+'숫자만 입력가능합니다'},
					tel2:{required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다',
						digits : '&nbsp&nbsp&nbsp'+'숫자만 입력가능합니다'},
					tel3:{required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다',
						digits : '숫자만 입력가능합니다'},
					postcode:{required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다'},
					addr1:{required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다'},
					addr2:{required : '&nbsp&nbsp&nbsp'+'필수입력항목 입니다'}
				},
				
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
				},
				
			
			
			});
			
		});
		
		
		function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                var fullAddr = '';
	                var extraAddr = '';
	                if (data.userSelectedType === 'R') {
	                    fullAddr = data.roadAddress;
	                } else {
	                    fullAddr = data.jibunAddress;
	                }
	                if(data.userSelectedType === 'R'){
	                    if(data.bname !== ''){
	                        extraAddr += data.bname;
	                    }
	                    if(data.buildingName !== ''){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	                }
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById('sample6_address').value = fullAddr;
	                document.getElementById('sample6_address2').focus();
	            }
	        }).open();
	    }
		
	</script>
</body>
</html>