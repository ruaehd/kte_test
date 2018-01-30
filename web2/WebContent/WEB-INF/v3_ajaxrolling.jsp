<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ajax_rolling</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="container">
	<!-- 	<button type="button" class="btn btn-default" id="prev">이전</button>
		<button type="button" class="btn btn-default" id="next">다음</button>
		<button type="button" class="btn btn-default" id="play">재생</button>
		<button type="button" class="btn btn-default" id="stop">중지</button> -->
		
		<div class="well well-lg" id="jrolling">
			<c:forEach var="vo" items="${list}" varStatus="i">
				<div class="item">${i.count}-${vo.title}</div>
			</c:forEach>
		</div>
		<hr />
		<form id="form">
			<input type="file" id="file1" name="file1" />
			<input type="submit" value="업로드" />
		</form>
		
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/jquery.syaku.rolling.js"></script>
	<script src="js/jquery.form.min.js"></script> 
	<script src="js/code.min.js"></script>
	<!-- <script>
		$(function(){
			//id가 form인 태그안에 있는 submit버튼이 클릭되면
			$('#form').submit(function(event){
				//event.preventDefault();
				var file = new FormData($(this)[0]);
				
				var a = $('#file1').val();
				
				if(a==""){
					alert('파일이 없습니다');
				}
				else{
					$.ajax({
						url:'v3_json_upload.do',	//JSON서버 주소
						type:'POST',	//method
						data:file, //전송할 데이터
						async:false,
						contentType:false,
						processData:false,
						success : function(data){	//성공하면
							if(data.ret =='y'){
								alert('업로드 성공');
							}
							else{
								alert('업로드 실패')
							}
						$('#file1').val("");
						}
					});	
				}
				return false;
			});
			
			
			$('#jrolling').jrolling({
				'items' : '#jrolling .item',
				'width' : '220px',
				'height' : '84px',
				'frame' : 500,
				'delay' : 1000,
				'move' : 'up',
				'auto' : true,
				'prev' : null,
				'next' : null,
				'play' : null,
				'stop' : null
			});
			//일정시간마다 수행됨
			setInterval(function(){
				$.get('v3_json_rolling.do', function(data){
					
					var len = data.length;
					for(var i=0; i<len; i++){
						$('.item').eq(i).text((i+1)+"-"+data[i].title);
					}
					
					/* //class가 item인 것을 반복 시킴
					$('.item').each(function(idx){
						$(this).text(new Date())
					}); */
				}, 'json');
			}, 5000);
		});
	</script> -->
</body>
</html>