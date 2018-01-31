<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>로그인</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:500px; padding:10px 50px; margin:100px auto; border:solid 1px #ccc">
			<h3>로그인</h3>
			<hr />
			<div class="form-inline" style="margin-bottom:10px">
				<label style="width:100px">아이디</label>
				<input type="text" name="id" id="id" class="form-control" placeholder="아이디를 입력하세요" />
			</div>
			<div class="form-inline" style="margin-bottom:10px">
				<label style="width:100px">비밀번호</label>
				<input type="password" name="pw" id="pw" class="form-control" placeholder="비밀번호를 입력하세요" />
			</div>
			<hr />
			<div class="form-inline" style="margin-bottom:10px" align="right">
				<a href="#"><input type="button" class="btn btn-success" id="btn_login" value="로그인"></a>
				<a href="#"><input type="button" class="btn btn-info" value="회원가입"></a>
			</div>
		</div>
	</div>
	
	<script src="resources/js/jquery-1.9.1.min.js"></script>		
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		$(function(){	
			$(document).ready(function(){
				$('#btn_login').click(function(){	//btn이 클릭되면
					var a =$('#id').val();	//id가 id인 태그의  값
					var c =$('#pw').val();
					
					if(a==''){	//a가 비어 있다면
						alert("아이디를 입력하세요");
						$('#id').focus();
						return false;
					}
					if(c==''){	//c가 비어 있다면
						alert("암호를 입력하세요");
						$('#pw').focus();
						return false;
					}
				});
			});
		});
	</script>		
	
</body>
</html>