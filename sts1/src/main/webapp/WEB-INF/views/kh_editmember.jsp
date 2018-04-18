<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원정보 수정</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div style="width:800px; padding:10px 50px; margin:10px auto; border:solid 1px #ccc">
			<h3>회원 정보 수정</h3>
			<hr />
			<div class="form-inline" style="margin-bottom:10px">
				<label style="width:100px">이름</label>
				<input type="text" name="name" id="name" style="width:50%" class="form-control" placeholder="이름을 입력하세요" />
			</div>
			<div class="form-inline" style="margin-bottom:10px">
				<label style="width:100px">전화번호</label>
				<select class="form-control" style="width:100px">
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
				<input type="text" name="addr1" id="addr1" style="width:25%" class="form-control" placeholder="우편번호" readonly/>
				<a href="#"><input type="button" class="btn btn-success" value="검색"></a>
			</div>
			<div class="form-inline" style="margin-bottom:10px">
				<label style="width:100px"></label>	
				<input type="text" name="addr2" id="addr2" style="width:50%" class="form-control" placeholder="상세주소1" readonly/>
			</div>
			<div class="form-inline" style="margin-bottom:10px">
				<label style="width:100px"></label>
				<input type="text" name="addr3" id="addr13" style="width:50%" class="form-control" placeholder="상세주소2" />
			</div>
			<hr />
			<div class="form-inline" style="margin-bottom:10px" align="right">
				<a href="#"><input type="button" class="btn btn-success" value="정보수정"></a>
				<a href="#"><input type="button" class="btn btn-info" value="취소"></a>
			</div>
		</div>
	</div>
</body>
</html>