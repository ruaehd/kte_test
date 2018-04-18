<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>파일관리</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
	<style>
		.table.table-borderless td, .table.table-borderless th {
			border : 0; !important;
		}
	</style>
</head>

<body>
	<div class="container">
		<form action="adminupload.do" method="post" enctype="multipart/form-data">
			<table class="table table-borderless">
				<tr>
					<td><input type="file" name="file" accept=".pdf, .gif, .png, .jpg"/></td>
					<td><input type="text" name="text" class="form-control" /><td>
					<td><input type="submit" class="btn btn-success" value="등록" /></td>
				</tr>
			</table>
			
			<table class="table">	
				<tr>
					<th>번호</th>
					<th>파일명</th>
					<th>설명</th>
					<th>날짜</th>
				</tr>
				
				<c:forEach var="vo" items="${list}">				
				<tr>
					<td class="td_fileno">${vo.no}</td>
					<td><a title="a.pdf" href="displayfile.do?no=${vo.no}" target="_blank" class="a_filename">${vo.filename}</a></td>
					<td class="td_text">${vo.text}</td>
					<td class="td_date1">${vo.date1}</td>
					<td>
						<a href="#" class="btn btn-xs btn-success btn_update">수정</a>
						<a href="#" class="btn btn-xs btn-danger btn_delete">삭제</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	
	<form action="admindelete.do" method="post">
		<div class="modal fade" id="deletemodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4>삭제</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" id="txt_fileno" name="txt_fileno" />
						<label id="label_filename"></label>
						삭제 하시겠습니까?
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-success" value="삭제" />
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	<form action="adminupdate.do" method="post" enctype="multipart/form-data">
		<div class="modal fade" id="updatemodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4>수정</h4>
					</div>
					<div class="modal-body">
						<input type="text" id="no" name="no" class="form-control" readonly/>
						<input type="text" id="text" name="text" class="form-control"/>
						<input type="file" id="file" name="file" class="form-control"/>
						<img src="resources/imgs/default.png" width="100px" height="100px" id="preview_img"/>
						<input type="text" id="filename" name="filename" class="form-control"/>
						<input type="text" id="date1" class="form-control" readonly/>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-success" value="수정" />
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$('#file').change(function(){
				//현재 파일을 img변수에 넣음
				var img = this;
				//img변수에 값이 있다면, 파일을 선택했다면
				if(img.files && img.files[0]){
					//파일을 읽기위한 객체 생성
					var reader = new FileReader();
					//파일을 읽어 들임.
					reader.onload = function(e){
						$('#preview_img').attr('src', e.target.result);
					};
					//파일의 링크를 읽음
					reader.readAsDataURL(img.files[0]);
				}
				else{	//파일을 선택하지 않았다면
					$('#preview_img').attr('src', 'resources/imgs/default.png');
				}
			});
			
			
			$('.btn_delete').click(function(){
				var idx =$(this).index('.btn_delete');
				var fn = $('.a_filename').eq(idx).text();
				var no = $('.td_fileno').eq(idx).text();
				
				$('#label_filename').text(fn);
				$('#txt_fileno').val(no);
				$('#deletemodal').modal('show');
			});
			
			$('.btn_update').click(function(){
				var idx =$(this).index('.btn_update');
				var fn = $('.a_filename').eq(idx).text();
				var no = $('.td_fileno').eq(idx).text();
				var tx = $('.td_text').eq(idx).text();
				var dt = $('.td_date1').eq(idx).text();
				
				$('#no').val(no);
				$('#text').val(tx);
				$('#filename').val(fn);
				$('#date1').val(dt);
				
				
				$('#updatemodal').modal('show');
			});
			$('#filename').click(function(){
				$('#file').click();
			});

		});
	</script>	
</body>
</html>
