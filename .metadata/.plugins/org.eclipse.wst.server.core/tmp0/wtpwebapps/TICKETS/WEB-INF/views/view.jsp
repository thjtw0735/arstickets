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
<link rel="stylesheet" href="/resources/css/view.css">
</head>
<body style="background:#e9eef7;">



<div class="contents_wrap">
	<div class="top_menu">
		<div class="seat_level">등급/좌석선택</div>
		<div class="ticket_check">배송선택/매수확인/결제</div>
	</div>
	<div class="contents" style="background: #f00000;">
	<div class="contents_top">
	<img src="${match.get(0).match_himage}" class="image"><input type="text" value="${match.get(0).match_home}     VS     ${match.get(0).match_away}" class="home" readonly><img src="${match.get(0).match_aimage}" class="image" readonly> <input type="text" value="${match.get(0).match_stadium}" class="detail" readonly> <input type="text" value="${match.get(0).match_date}" class="detail" readonly>
	</div>
	<div class="contents_left">
		<table border="1" class="table_left">
			<tr class="choice">
				<td rowspan="3" class="choicestyle">W</td>
				<td style="font-size: 31px;background-color: rgb(251, 251, 251);font-weight: bold;">N</td>
				<td rowspan="3" class="choicestyle">E</td>
			</tr>
			<tr>
				<td style='background-image : url("/resources/image/stadium.jpg");background-size: cover;width: 50%;height: 40%;'></td>
			</tr>
			<tr class="choice">
				<td style="font-size: 31px;background-color: rgb(251, 251, 251);font-weight: bold;" id="se4">S</td>
			</tr>
   		</table>
	</div>
	<div class="contents_right">
  		<table border="none" class="table_right">
			<tr>
				<td class="topstyle">등급</td>
				<td class="topstyle">가격</td>
				<td class="topstyle">잔여석</td>
			</tr>
			<tr>
				<td>E석</td>
				<td>15,000</td>
				<td>${esection}석</td>
			</tr>
			<tr>
				<td>W석</td>
				<td>15,000</td>
				<td>${wsection}석</td>
			</tr>
			<tr>
				<td>S석</td>
				<td>20,000</td>
				<td>${ssection}석</td>
			</tr>
			<tr>
				<td>N석</td>
				<td>20,000</td>
				<td>${nsection}석</td>
			</tr>
   		</table>
   		<div class="button">
   			<button class="bt" onclick="closewindow()">Prev</button>
   			<button class="bt" onclick="checkseat()">Next</button>
   		</div>
	</div>
	</div>
</div>

<!-- 좌석 선택 모달창 -->	
<div id="seatModal" class="modal">
<!-- 	<button type="button" class="resv" onclick="reload()">새로고침</button> -->
	<input type="hidden" name="cols" value="10" />
  	<input type="hidden" name="rows" value="10" />
	<div class="wrap">
		<fieldset class="fieldset">
	    <p class="result" id="rst"></p>
		</fieldset>
	    <ul class="colsHead"></ul>
	    <ul class="rowsHead"></ul>
	    <ol class="seat"></ol>
	</div>
</div>
</body>
<script>

/* 	setInterval(function() {
		if( '${sessionScope.email}' == null ){
			alert("세션이 종료되었습니다. 다시 로그인 해주시기 바랍니다.");
			var address = "main.do";
			location.replace(address);
		}
	}, 1000); */
	
	// 모달창 닫기
	var modal1 = document.getElementById('seatModal');
	window.onclick = function(event) {
	     if (event.target == modal1) {
	        /* modal1.style.display = "none"; */
			location.reload();
	    }
	}


	var $cols = $('input[name=cols]'),
	$rows = $('input[name=rows]'),
	$result = $('.result'),
	$seat = $('.wrap .seat'),
	$colsHead = $('.wrap .colsHead'),
	$rowsHead = $('.wrap .rowsHead'),
	colsNum = 0, rowsNum = 0;

	// 화면 업데이트
	var updateView = function() {
	var makeTag = '', i = 1, leng = 0;

	colsNum = parseInt($cols.val() || 0, 10);
	rowsNum = parseInt($rows.val() || 0, 10);
	for(i = 1, leng = colsNum * rowsNum; i <= leng; i++) {
	    if( i % colsNum === 1 ) {
	        makeTag += "<li class='ll' style='clear:both;'></li>";
	    } else {
	        makeTag += "<li class='ll'></li>";
	    }
	}
	$seat.html(makeTag);

	for(makeTag = '', i = 1, leng = colsNum; i <= leng; i++) {
	    makeTag += '<li>' + i + '</li>';
	}
	$colsHead.html(makeTag);

	for(makeTag = '', i = 65, leng = 65 + rowsNum; i < leng; i++) {
	    makeTag += '<li>' + String.fromCharCode(i) + '</li>';
	}
	$rowsHead.html(makeTag);

	/* $result.html('nothing'); */
	};

	var onoff = "0";
	var colsIndex="";
	var rowsName="";
	var seat =""; 
	var ind = "";

	// 선택한 자리에 대해서 index를 가지고 seat, ind 문자열로 만들기	
	var getSeatName = function( index ) {
		colsIndex = (index % colsNum) + 1;
	var rowsIndex = Math.ceil((index + 1) / colsNum) - 1;
	    rowsName = String.fromCharCode((65 + rowsIndex));
	    
	    if(seat.indexOf("," + rowsName+colsIndex) != -1){
	    	seat = seat.replace("," + rowsName+colsIndex,'');
	    	ind = ind.replace("," + index , '');
	    } else {
	    	if (seat.indexOf(rowsName+colsIndex) != -1){
	    		if(seat.indexOf(",") != -1) {
		    		seat = seat.replace(rowsName+colsIndex + ",",'');
		    		ind = ind.replace(index +",",'');
	    		} else {
	    			seat = seat.replace(rowsName+colsIndex,'');
	    			ind = ind.replace(ind,'');
	    		}
	    	} else {
			    if (seat == ""){
					seat = rowsName + colsIndex;
					ind = index;
				} else {
					// , 갯수로 4자리 초과 시 좌석 선택 불가
					var match = seat.match(/,/g);
					if( match != null ){
					var count = match.length;
					}
		
					if( count > 2 ){
						alert("4좌석까지만 선택 가능합니다.");
						onoff = "1";
					} else {
						seat += "," + rowsName + colsIndex;
						ind += "," + index;
					}
				}
	    	}
	    }
	    
		return rowsName + ' cols ' + colsIndex + '';
	};


	 var values = "";
	 var level = "";
	 var date = "";
	 // 구역 선택 시 해당 구역 seat정보 불러오기
	$('.choice').on('click', 'td', function() {
			var $levelchoice = $(this);
		    level = $levelchoice.text();
		    $('#rst').text(level);
		    date="${match.get(0).match_date}";
		  	/* $(".seat li").css("background","none"); */
			$.ajax({
				  method: "POST",
				  url: "seatselect.do",
				  data: {
					  level : level,
					  date : date
				  },
				  success : function(result){
					  if(result.code == "OK"){
						  	values = result.ticketIndex;
						  	$.each(values, function( index, value ) {
						  		$(".seat li").eq(value).prop("disabled", true);
				                $(".seat li").eq(value).css("background","orange");
				                });
							
						 	 document.getElementById('seatModal').style.display='block';
							
					  }else if(result.code == "NOT"){
						  alert("good");
					  } else {
						 alert("fail");
					  }
				  },
				  error:function(request,status,error){
				        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				  }
			})
	});
	
	
	// 좌석 선택 시 getSeatName 실행 및 배경색 변경
	$seat.on('click', 'li', function() {

				var $this = $(this),
			    index = $this.index();				
		 		getSeatName(index);
				if( onoff == "0"){
			 	 	$this.toggleClass('reserve');
				}
		 	 	if ( onoff == "1"){
		 	 		onoff = "0";
				}
	});
	
	
	// 좌석선택 후 NEXT 버튼을 눌러 다음단계로 넘어갈때 
	function checkseat() {
		var price ="";
		if( level =="N" || level == "S"){
			price = "20000";
		} else {
			price = "15000";
		}
		
		if ( seat == ""){
			alert("좌석을 먼저 선택 해주세요");
		} else {
			$.ajax({
				  method: "POST",
				  url: "insertseat.do",
				  data: {
					  ind : ind,
					  seat : seat,
					  date : date,
					  level : level,
					  price : price
				  },
				  success : function(data){
					  if(data == "1"){
						  alert("이미 선택된 자리입니다.");
						  location.reload();
					  }else{
						  var resvcheck = "1";
						  var date="${match.get(0).match_date}";
						  var address = "reservation.do?resvcheck=" + resvcheck + "&date="+ date + "&seat=" + seat + "&level=" + level + "&price=" + price;
						  location.replace(address);
					  }
				  },
				  error:function(request,status,error){
				        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				  }
				})
		}
	}

	function closewindow() {
		window.close();
	}
	
	//새로고침 작업으로 예매된 자리 확인가능
	function reload(){
		location.reload();
	  /*  $.ajax({
			  method: "POST",
			  url: "seatselect.do",
			  data: {
				  level : level,
				  date : date
			  },
			  success : function(result){
				  if(result.code == "OK"){
					  alert(seat);
					  alert(ind);
					  	seat = "";
					  	ind = "";
					  	alert(seat);
						  alert(ind);
					  	$(".seat li").prop("disabled", false );
					  	alert("1");
					    $(".seat li").css("background","none");
					  	alert("2");
					  	values = result.ticketIndex;
					  	$.each(values, function( index, value ) {
					  		$(".seat li").eq(value).prop("disabled", true);
			                $(".seat li").eq(value).css("background","orange");
			                });
						
						 document.getElementById('seatModal').style.display='block'; 
						
				  }else if(result.code == "NOT"){
					  alert("good");
				  } else {
					 alert("fail");
				  }
			  },
			  error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			  }
		}) */
	}

	updateView();

</script>
</html>