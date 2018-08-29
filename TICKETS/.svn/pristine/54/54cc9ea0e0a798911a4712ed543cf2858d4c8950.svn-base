<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Tickets</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="/resources/css/mypage.css">
	<link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
	<!-- header 부분 -->
	<jsp:include page="header.jsp" flush="false" />
	<!-- 테이블 부분 -->
	<div class="container-table">
		<!-- <div class="search-period" ><input type="text" class="period-text" readonly value="기간별 조회"></div>
		<div><button class="period">15일</button></div>
		<div><button class="period">30일</button></div> -->
		<div class="search-right">
			<div class="search-date" ><input type="text" class="period-text" readonly value="날짜별 조회"></div>
			<div class="search-picker"><input type="text" id="testDatepicker"></div>		
			<div class="search-checked"><button class="search-button" onclick="searchdate()">조회</button></div>
		</div>
		<table class="table table-striped" id="tableid">
			<thead>
			<tr>
				<th class="page">예매번호</th>
				<th class="page">예매정보</th>
				<th class="page">예매날짜</th>
				<th class="page">매수</th>
				<th class="page">좌석</th>
				<th class="page">예매취소</th>
				<th class="page">예매상태</th>
			</tr>
			</thead>
			<tbody class="tbody">
			<c:set var="match" value="${matchlist}"/>
			<c:forEach items="${shippinglist}" varStatus="status">
				<tr class="hahaha">
					<td id="rvnum">${shippinglist[status.index].shipping_num}</td>
					<td>${matchlist[status.index].match_home} VS ${matchlist[status.index].match_away} ${matchlist[status.index].match_date}</td>
					<td id="matchdate">${shippinglist[status.index].shipping_date}</td>
					<td>${shippinglist[status.index].shipping_count}</td>
					<td id="tkseat">${shippinglist[status.index].shipping_ticket}</td>
					<c:if test="${shippinglist[status.index].shipping_status == '취소완료' }">
						<td class="rv"><button class="rv-cancel" data-seq="${status.index}" style=" background : gray;" disabled>취소</button></td>
					</c:if>
					<c:if test="${shippinglist[status.index].shipping_status == '예매완료' }">
						<td class="rv"><button class="rv-cancel" data-seq="${status.index}">취소</button></td>
					</c:if>
					<td id="confirm">
						<div class="box1">
							<div class="aa"  data-seq="${status.index}" >${shippinglist[status.index].shipping_status}</div>
						</div>
					</td>
					<td><input type="hidden" id="hidden" value="${matchlist[status.index].match_date}"></td>
					<div class="pop1">
					   <div class="bb" style="text-align : left; padding-left: 5px; font-weight: bold;">
						주문자 : ${shippinglist[status.index].shipping_name}<br>
						연락처 :  ${shippinglist[status.index].shipping_phone}<br>
						 배송지 :  ${shippinglist[status.index].shipping_address}
					   </div>
					</div>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<hr/>
		<div class="text-center">
			<ul class="pagination">
				<div>
					<c:if test="${cdate == null}">
						<c:if test="${startPage > pageBlock}">
						    <a class="btn-prev" href="mypage.do?pageNum=${startPage-pageBlock}">이전</a>
					    </c:if>
					    <c:if test="${startPage < pageBlock}">
						    <a class="btn-prev" style="color: white;">이전</a>
					    </c:if>
					</c:if>
					<c:if test="${cdate != null}">
						<c:if test="${startPage > pageBlock}">
						    <a class="btn-prev" href="mypage.do?pageNum=${startPage-pageBlock}&cdate=${cdate}&date=${date}">이전</a>
					    </c:if>
					</c:if>
				</div>
				<c:set var="pageNum" value="${pageNum}"></c:set>
				<div class="pa">
			    	<c:forEach var="i" begin="${startPage}" end="${endPage}">
			    		<c:if test="${cdate == null}">
				    		<c:if test="${pageNum==i}">
				    			<li class="cover"><a href="mypage.do?pageNum=${i}"><span>${i}</span></a></li>
				    		</c:if>
				    		<c:if test="${pageNum != i}">
								<li><a href="mypage.do?pageNum=${i}"><span>${i}</span></a></li>
							</c:if>
			    		</c:if>
			    		<c:if test="${cdate != null}">
				    		<c:if test="${pageNum==i}">
				    			<li class="cover"><a href='mypage.do?pageNum=${i}&cdate=${cdate}&date=${date}'><span>${i}</span></a></li>
				    		</c:if>
				    		<c:if test="${pageNum != i}">
								<li><a href='mypage.do?pageNum=${i}&cdate=${cdate}&date=${date}'><span>${i}</span></a></li>
							</c:if>
			    		</c:if>
			    	</c:forEach>
				</div>
				<div>
		    	<c:if test="${cdate == null}">
				    <c:if test="${pageCount > endPage}">
					    <a class="btn-next" href="mypage.do?pageNum=${startPage+pageBlock}">다음</a>
					</c:if>
				</c:if>
				<c:if test="${cdate != null}">
				    <c:if test="${pageCount > endPage}">
					    <a class="btn-next" href="mypage.do?pageNum=${startPage+pageBlock}&cdate=${cdate}&date=${date}">다음</a>
					</c:if>
				</c:if>
				</div>
			</ul>
		</div>
	</div>
<br><br><br>

<!-- footer페이지 -->
<jsp:include page="footer.jsp" flush="false" />
</body>
<script>


/* 	setInterval(function() {
		if( '${sessionScope.email}' == null ){
			alert("세션이 종료되었습니다. 다시 로그인 해주시기 바랍니다.");
			var address = "main.do";
			location.replace(address);
		}
	}, 1000);
 */	
	
 	// datepicker 사용
	$(function() {
	    $( "#testDatepicker" ).datepicker({
	    		dateFormat : 'yy-mm-dd'
	    });
	});

 
	//예매 취소버튼 클릭 
	$(".rv-cancel").click(function() {
    	var dataseq=$(this).data('seq');
    	var seats = $('#tableid .tbody tr').eq(dataseq).find('#tkseat').text();
    	var dates = $('#tableid .tbody tr').eq(dataseq).find('#hidden').val();
    	var rvnum = $('#tableid .tbody tr').eq(dataseq).find('#rvnum').text();
    	
		if( confirm("예매를 취소하시겠습니까?") == true ){
			$.ajax({
				method: "POST",
				url: "seatdelete.do",
				data: {
					seats : seats,
					dates : dates,
					rvnum : rvnum
				},
				success : function(result){
					
					if(result.code == "OK"){
						alert("예매가 취소되었습니다.");
						 $('#tableid .tbody tr').eq(dataseq).find('#confirm').text("취소완료");
						 $('#tableid .tbody tr').eq(dataseq).find('.rv-cancel').prop("disabled", true);
						 $('#tableid .tbody tr').eq(dataseq).find('.rv-cancel').css("background", "gray");
					} else {
						alert("실패");
					}
					
				},
				error:function(request,status,error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			})
		} else {
			return;			
		}
	});

	
	// hover 시 효과
	$(".box1 .aa").hover(function(){
		var backseq=$(this).data('seq');
	     $(this).append("<div class='view'></div>");
	     $(".pop1 .bb").eq(backseq).clone().appendTo(".view",this);
	},function(){
	     $(".view",this).remove();
	})
	
	// 날짜 조회 버튼 클릭 시
	function searchdate(){
		var pickerdate = $('#testDatepicker').val();
	 	if( pickerdate == "" ){
			alert("날짜를 먼저 선택해 주세요");
		} else {
			var cdate = "1";
			var address = "mypage.do?date=" + pickerdate + "&cdate=" + cdate;
			location.replace(address);
		}
	}

	// 마이페이지 reload
	function fk() {
			var address = "mypage.do";
			location.replace(address);
	}
</script>
</html>
