<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ajax_질문 및 답변</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<table class="table" id="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<ul id="mypagination"></ul>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/jquery.twbsPagination.js"></script>
	
	<script>
		$(function(){
			$.get('v3_json_boardqnatot.do?txt=', function(data1){
				$('#mypagination').twbsPagination({
					totalPages:data1.tot,
					onPageClick : function(evt, page){
						$('#table tbody').empty();
						$.get('v3_json_boardqna.do?page='+page+'&txt=', function(data){
							var len = data.length;
							for(var i=0;i<len;i++){
								$('#table tbody').append(
									'<tr>'+
										'<td>'+data[i].no+'</td>'+
										'<td>'+data[i].title+'</td>'+
										'<td>'+data[i].writer+'</td>'+
										'<td>'+data[i].hit+'</td>'+
										'<td>'+data[i].date1+'</td>'+
									'</tr>'
								);		
							}
						}, 'json');
					}
				});
			}, 'json');
			
			
			
		/* 	$.get('http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20120101', function(data){
				
				var a1 = data.boxOfficeResult;
				var d1 = a1.dailyBoxOfficeList;
				var len = d1.length;
				
				for(var i=0;i<len;i++){
					$('#table1').append(
						'<tr>'+
							'<td>'+d1[i].rnum+'</td>'+
							'<td>'+d1[i].rank+'</td>'+
							'<td>'+d1[i].rankInten+'</td>'+
							'<td>'+d1[i].rankOldAndNew+'</td>'+
							'<td>'+d1[i].movieCd+'</td>'+
							'<td>'+d1[i].movieNm+'</td>'+
							'<td>'+d1[i].openDt+'</td>'+
						'</tr>'	
					);
				}
			}, 'json'); */
			
		});
	</script>
</body>
</html>