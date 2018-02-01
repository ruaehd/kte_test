<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>로그인</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:500px; padding:30px 0; margin:100 auto">
			<form>
				<h3>로그인</h3>
				<hr />
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">회원번호</label>
					<input type="text" name="id" id="id" class="form-control" placeholder="아이디를 입력하세요"/>
				</div>
				<div class="form-inline" style="margin-bottom:10px">
					<label style="width:100px">비밀번호</label>
					<input type="password" name="pw" id="pw" class="form-control" placeholder="비밀번호를 입력하세요"/>
				</div>
				
				
				<hr />
				<div align="right">
					<input type="submit" class="btn btn-success" id="btn_submit" value="로그인" />
					<a href="#"><input type="button" class="btn btn-info" value="회원가입" /></a>
				</div>
			</form>
		</div>
	</div>
	
	<script src="resources/js/jquery-1.9.1.min.js"></script>	
	
	<script>
		$(function(){
			$(document).ready(function(){
				$('#btn_submit').click(function(){	//btn이 클릭되면
					var a =$('#id').val();	//id가 id인 태그의  값
					var c =$('#pw').val();
				
					if(a==''){	//a가 비어 있다면
						alert("아이디를 입력하세요");
						$('#id').focus();
						return false;
					}
					if(c==''){	//c가 비어 있다면
						alert("비밀번호를 입력하세요");
						$('#pw').focus();
						return false;
					}
				})
			});
		});
	</script>
</body>
</html>
