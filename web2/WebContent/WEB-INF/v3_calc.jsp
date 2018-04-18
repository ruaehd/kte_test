<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewpoint" content="width=device-width, initial-scale=1, user-scalable=no, maximum-scale=1" />	<!-- 모바일용 -->
	<meta charset="UTF-8">
	<title>주문하기</title>
	<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="container" style="padding:30px 0">
		<table class="table">
			<tr>
				<th><input type="checkbox" />선택</th>
				<th>상품코드</th>
				<th>상품명</th>
				<th>가격</th>
				<th>주문수량</th>
				<th>합계</th>
			</tr>
			<c:forEach begin="1" end="10" var="i">
				<tr>
					<td><input type="checkbox" class="chk_item" /></td>
					<td>${i}</td>
					<td>가나다</td>
					<td><font class="lbl_price">1,000</font>원</td>
					<td>
						<select class="form-control sel_cnt">
							<c:forEach begin="1" end="20" var="j">
								<option value="${j}">${j}</option>
							</c:forEach>
						</select>
					</td>
					<td><font class="lbl_sum" >1,000</font>원</td>
				</tr>
			</c:forEach>
			<tr>
				<th>전체합계</th>
				<td colspan="5"><font id="lbl_tot">0</font>원</td>
			</tr>
		</table>
	
	
	</div>
	
	<script src="js/jquery-1.9.1.min.js"></script>
	<script>
		$(function(){
			
			var numberFormat2 = function(num){
				var str = "";
				num = num + "";			//1234567890	1,234,567,890
				var len = num.length;	// 10
				var idx = len % 3;   	//	1

				for(var i=0;i<len;i++){
					if( (i>2) && ((i%3) == idx) ){
						str += ",";
					}
					str += num[i];
				}
				return str;
			};
			
			var numberFormat1 = function(num){
				num += "";
				var pattern = /(-?[0-9]+)([0-9]{3})/;
				while(pattern.test(num)){
					num = num.replace(pattern, "$1,$2");
				}
				return num;
			};
			
			//jquery에서 함수 만들기
			var numberFormat = function(num){
				var str;
				num = num+"";	//길이를 구하기 위해 숫자를 문자로 변경		
				var len = num.length;
				var idx = num.length % 3;
				str = num.substring(0, idx);	//substring(시작,갯수)	idx가 0이면 str=0
				
				while(idx < len){
					//3자리 이상인 경우에 해당, idx가 0이면 str=0이 되어 if 통과
					if(str != ""){
						str += ",";
					}
					str += num.substring(idx, idx+3);	
					idx += 3;
				}
				return str;
			};
			
			var calcTot = function(){
				var tot = 0;
				$('.chk_item').each(function(){	//체크되었다면
					if($(this).is(':checked')){
						var idx = $(this).index('.chk_item');
						
						var sum = $('.lbl_sum').eq(idx).text();
						sum = sum.replace(/,/g, "");	//,제거
						tot += Number(sum);				//값을 누적
						$('#lbl_tot').text(numberFormat1(tot));
						console.log(idx+":"+sum);
					}
				});
			}
			
			//class가 sel_cnt인것이 변경되면
			$('.sel_cnt').change(function(){
				var idx = $(this).index('.sel_cnt');	//위치
				var cnt = $(this).val();	//수량
				
				var pri = $('.lbl_price').eq(idx).text();	//가격
				/* pri = pri.replace(",", ""); 1,000,000일 경우 하나만*/
				pri = pri.replace(/,/g, "");	//모두
				console.log(cnt*pri);
				
				var tmp = numberFormat1(cnt*pri);
				
				$('.lbl_sum').eq(idx).text(tmp);
				
				calcTot();
			});
			
			$('.chk_item').click(function(){	//체크박스 전체 반복
				calcTot();
			});
			
		});
	</script>
</body>
</html>