<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="/resources/css/resvcheck.css">
</head>
<body style="background:#e9eef7;">
	<div class="contents_wrap">
		<div class="top_menu">
			<div class="seat_level">등급/좌석선택</div>
			<div class="ticket_check">배송선택/매수확인/결제</div>
		</div>
		<div class="contents" style="background: #f00000;">
			<div class="contents_top">
			<img src="${match.get(0).match_himage}" class="image"><input type="text" value="${match.get(0).match_home}     VS     ${match.get(0).match_away}" class="home" readonly><img src="${match.get(0).match_aimage}" class="image" readonly> <input type="text" value="${match.get(0).match_stadium}" class="detail" readonly> <input type="text" value="${match.get(0).match_date}" class="detail" id="date" readonly>
			</div>
			<div class="contents_left">
			<form id="shippingForm">
				<table class="table_left">
					<tr>
						<td colspan="2" style="color:red;font-weight:bold;font-size:17px;"> 5분이내 결제하시면 예매가 완료 됩니다.</td>
					</tr>
					<tr>
						<td colspan="2" class="rvuser" style="font-weight:bold;">주문자 확인</td>
					</tr>
					<tr class="truser">
						<td>이름</td>
						<td>${user.name}</td>
					</tr>
					<tr class="truser">
						<td>휴대폰 번호</td>
						<td>${user.phone}</td>
					</tr>
					<tr class="truser">
						<td>주소</td>
						<td>${user.address}</td>
					</tr>
					<tr>
						<td colspan="2" class="rvuser" style="font-weight:bold;">배송정보                <input type="checkbox" id="chbox" >주문자 정보와 동일</td>
					</tr>
					<tr class="truser">
						<td>이름</td>
						<td><input type="text" id="shipping_name" name="shipping_name" class="delivery"></td>
					</tr>
					<tr class="truser">
						<td>휴대폰 번호</td>
						<td><input type="text" id="shipping_phone" name="shipping_phone"  class="delivery"></td>
					</tr>
					<tr class="truser">
						<td>주소</td>
						<td><input type="text" id="shipping_address" name="shipping_address"  class="delivery"></td>
					</tr>
					<tr>
					<input type="hidden" name="match_num" value="${match.get(0).match_num}">
					<input type="hidden" name="seat" value="${seat}">
					<input type="hidden" name="level" value="${level}">
					</tr>
		   		</table>
			</form>
			<tr>
				<button onclick="setaddress()" class="findad">우편번호찾기</button>
			</tr>
			</div>
			<div class="contents_right">
		  		<table border="0" class="table_right">
					<tr>
						<td colspan="2" class="rvheight" style="border-top-color : red;">예매정보</td>
					</tr>
					<c:forEach var="i" begin="0" end="3">
						<c:if test="${!empty st[i]}">
							<tr class="rvheight">
								<td>${level}석</td>
								<td>${st[i]}</td>
							</tr>
						</c:if>
						<c:if test="${empty st[i]}">
							<tr class="rvheight">
								<td></td>
								<td></td>
							</tr>
						</c:if>
					</c:forEach>
					<tr>
						<td colspan="2"/>
					</tr>
					<tr class="prheight">
						<td>티켓 금액</td>
						<td style="background-color: white">${ticketprice}원</td>
					</tr>
					<tr class="prheight">
						<td>예매 수수료</td>
						<td style="background-color: white">${vat}원</td>
					</tr>
					<tr class="prheight">
						<td>총 금액</td>
						<td style="background-color: white">${totalprice}원</td>
					</tr>
		   		</table>
		   		<div class="rvbutton">
		   			<button class="bt" onclick="backstep()" id="step">Prev</button>
		   			<button class="bt" onclick="nextseat()" id="step">Next</button>
		   		</div>
			</div>
		</div>
	</div>
</body>


<script>
/* 	window.addEventListener("beforeunload", function (e) {

	  var confirmationMessage = "Are you sure you want to leave this page without placing the order ?";
	  (e || window.event).returnValue = confirmationMessage;
	  return confirmationMessage;

	}); */
	
	
	
	
	 var secret ="";
	 var time = '${time}';
	 var checktime ="";
	 var now ="";
	 // session에 저장된 시간과 현재 시간을 매초 비교하여 5분 초과 시 예매 취소
	 var playAlert = setInterval(function() {
		 checktime = new Date();
		 now = checktime.getHours() + "" + checktime.getMinutes();
		 now *=1;
		 time *=1;
	 	 if( time < now ){
			 clearInterval(playAlert);
			 secret = "1";		 
		 }
		}, 1000);
	
	 // 우편번호 찾기
	 function setaddress() {
	     	var width = 500;
	    	var height = 600;
	    	daum.postcode.load(function(){
	    		new daum.Postcode({
	    			oncomplete: function( data ) {
	    				$("#shipping_address").val(data.roadAddress);
	    			}	
	    		}).open({
	    			left: (window.screen.width/2 ) - ( width/2 ),
	    			top: (window.screen.height/2 ) - ( height/2 ) 
	    		});
	    	});
	    	
	 }
	 
	 
	// 배송정보에서 이전단계로 가기
	function backstep(){
		if ( secret == "") {
			var seat = "${seat}";
			var level = "${level}";
			if( confirm("이전 단계로 이동 시 예매정보가 모두 취소 됩니다") == true ){
				var date = $("#date").val();
				var address = "reservation.do?level="+ level + "&seat=" + seat + "&date=" + date; 
				location.replace(address);
			} else {
				return;			
			}
		} else {
			seatdelete();
		}
	}
	
	// 예매 완료하고 마이페이지로 가기
	function nextseat(){
		if ( secret == "") {
			var idcheck = $('#shipping_name').val();
			var phonecheck = $('#shipping_phone').val();
			var addresscheck = $('#shipping_address').val();
			if( !idcheck || !phonecheck || !addresscheck ) {
				alert("배송정보를 입력해 주세요");
			} else {
				$.ajax({
					method: "POST",
					url: "mpinsert.do",
					data: $("#shippingForm").serialize(),
					success : function(result){
					 if(result.code == "OK"){
						alert("예매가 완료되었습니다.");
						var address = "mypage.do"
						window.opener.location.replace(address);
						window.close();
					 }else{
					 alert("fail");
					 }
					},
					error:function(request,status,error){
					      alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}
				})
			}
		} else {
			seatdelete();
		}
	}
	
	// 5분 시간초과로 인한 예매 취소 
 	function seatdelete(){
			var seat = "${seat}";
			var level = "${level}";
			var match_num = "${match.get(0).match_num}";
			$.ajax({
				  method: "POST",
				  url: "seatdelete.do",
				  data: {
					  level : level,
					  seat : seat,
					  match_num : match_num
				  },
				  success : function(result){
					  if(result.code == "OK"){
						  alert("5분 내 결제가 이루어지지 않아 예매가 취소됩니다.");
						  window.close();
					  }else{
						 alert("fail");
					  }
				  },
				  error:function(request,status,error){
				        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				  }
				})
	}
	
	// 주문자 정보와 동일할 경우
    $("#chbox").change(function(){
        if($("#chbox").is(":checked")){
            $.ajax({
				  method: "POST",
				  url: "userselect.do",
				  data: {
				  },
				  success : function(result){
					  if(result.code == "OK"){
						  	var name = result.user.name;
						  	var phone = result.user.phone;
							var address = result.user.address;
						  	$('#shipping_name').val(name);
						  	$('#shipping_phone').val(phone);
						  	$('#shipping_address').val(address);
					  }else{
						 alert("fail");
					  }
				  },
				  error:function(request,status,error){
				        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				  }
				})
        }else{
        	$('#shipping_name').val("");
		  	$('#shipping_phone').val("");
		  	$('#shipping_address').val("");
        }
    });
	
</script>
</html>