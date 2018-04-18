<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원목록</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="margin:0 auto; padding:30 0; width:1000px">
			<h3>회원목록</h3>
			<hr />
			<div style="margin-bottom:10">
				<input type="button" class="btn btn-info" id="btn_add" value="+" />
				<input type="button" class="btn btn-danger" id="btn_remove" value="-" />
				<div id="div_add"></div>
			</div>
			<table class="table">
				<tr>
					<th>차단</th>
					<th>아이디</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>전화번호</th>
					<th>휴대폰번호</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>가입날짜</th>
				</tr>
				<c:forEach var="vo" items="${list}" varStatus="i">
					<tr>
						<td>
							<c:if test="${vo.chk==0}">
								<input type="radio"	name="rad_${i.index}" value='{"chk":1, "id":"${vo.no}"}' checked/>O
								<input type="radio"	name="rad_${i.index}" value='{"chk":0, "id":"${vo.no}"}' />X
							</c:if>
							<c:if test="${vo.chk==1}">
								<input type="radio"	name="rad_${i.index}" value='{"chk":1, "id":"${vo.no}"}' />O
								<input type="radio"	name="rad_${i.index}" value='{"chk":0, "id":"${vo.no}"}' checked/>X
							</c:if>
						</td>
						<td>${vo.no}</td>
						<td>${vo.name}</td>
						<td>${vo.birth}</td>
						<td>${vo.tel}</td>
						<td>${vo.phone}</td>
						<td>${vo.postcode}</td>
						<td>${vo.addr}</td>
						<td>${vo.date1}</td>
					</tr>
				</c:forEach>
			</table>
			<hr />
			<%-- <table class="table">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>전화번호</th>
					<th>휴대폰번호</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>가입날짜</th>
				</tr>
				<c:forEach var="vo" items="${list1}" varStatus="i">
					<tr>
						<td>${vo.no}</td>
						<td>${vo.name}</td>
						<td>${vo.birth}</td>
						<td>${vo.tel}</td>
						<td>${vo.phone}</td>
						<td>${vo.postcode}</td>
						<td>${vo.addr}</td>
						<td>${vo.date1}</td>
					</tr>
				</c:forEach>
			</table> --%>
		</div>
	</div>
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
	<script>
		$(function(){
			//input type="radio"인 것이 클릭되면
			$('input[type=radio]').click(function(){
				//클릭된 개체의 value값을 읽어옴
				//{"chk":1, "id":"abc"}
				var data = $(this).val();
				data = JSON.parse(data);
				
				//get방식의 ajax를 통해서 db에 업데이트함
				$.get('json_memberblock.do?id='+data.id+'&chk='+data.chk, function(rdata){
					if(rdata.ret == 'y'){
						alert('변경되었습니다');		
					}	
				},'json');
			});
			
			var chk = 0;
			
			$('#btn_add').click(function(){
				if(chk==0){
					$('#div_add').append(
						'<form action="join.do"method="post"id="form"><div style="margin-top:10px"><table class="table"><tr><th>아이디</th><th>이름</th><th>생년월일</th><th>전화번호</th><th>휴대폰번호</th><th>우편번호</th><th>주소</th><th>가입날짜</th><th>등록</th></tr><tr><td><input type="text"name="id"id="id"class="form-control"/></td><td><input type="password"name="pw"id="pw"class="form-control"/></td><td><input type="text"name="name"class="form-control"/></td><td><input type="text"name="birth"class="form-control"/></td><td><input type="text"name="tel"class="form-control"/></td><td><input type="text"name="phone"class="form-control"/></td><td><input type="text"name="postcode"class="form-control"/></td><td><input type="text"name="addr"class="form-control"/></td><td><input type="submit"class="btn btn-success"value="회원가입"/></td></tr></table></div></form>'
					);
				}
				chk = 1;
			});
			
			$('#btn_remove').click(function(){
				chk = 0;
				$('#div_add').empty();
			});
		});
	</script>
</body>
</html>
