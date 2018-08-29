<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Tickets</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/css/main.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <style>
</style>
</head>
<body>
<jsp:include page="header.jsp" flush="false" />
<embed src="/resources/image/sleep.mp3" autostart="false" loop="false" width="280" height="280" hidden="false">
<div id="myCarousel" class="carousel slide text-center" data-ride="carousel" data-interval="3000" >
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
    	<a href="https://www.arsenal.com${linklist[2]}" target="_blank" class="carousel-link">
    	<img src="https://www.arsenal.com${imglist[0]}" class="imgsize">
       <div class="carousel-caption">
        <h4>${newslist[0]}</h4>
       </div>
    	</a>
    </div>
    <div class="item">
    	<a href="https://www.arsenal.com${linklist[3]}" target="_blank" class="carousel-link">
    	<img src="https://www.arsenal.com${imglist[1]}" class="imgsize">
       <div class="carousel-caption">
        <h4>${newslist[1]}</h4>
       </div>
    	</a>
    </div>
    <div class="item">
    	<a href="https://www.arsenal.com${linklist[4]}" target="_blank" class="carousel-link">
    	<img src="https://www.arsenal.com${imglist[2]}" class="imgsize">
       <div class="carousel-caption">
        <h4>${newslist[2]}</h4>
       </div>
    	</a>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only"></span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only"></span>
  </a>
</div>
<div class="container-body">    
  <div class="row">
	<div class="card">
	    <img src="${ftlist[7]}" class="card-image" style="float:left;" id="imaa"> 
	    <div class="card-body" style="float:left;">
	        <h3 class="card-title">${ftlist[4]} VS ${ftlist[5]}</h3>
	        <p class="card-text">${ftlist[2]} | ${ftlist[0]}</p>
	        <a href="javascript:reservation_first();" class="btn btn-primary">reservation</a>
	    </div>
	    
	    <img src="https://www.arsenal.com${ftlist[8]}" class="card-image"> 
	</div>
    <div class="card">
	    <img src="${ftlist[7]}" class="card-image" style="float:left;"> 
	    <div class="card-body" style="float:left;">
	        <h3 class="card-title">${ftlist[4]} VS ${ftlist[6]}</h3>
	        <p class="card-text">${ftlist[3]} | ${ftlist[1]}</p>
	        <a href="javascript:reservation_second();" class="btn btn-primary">reservation</a>
	    </div>
	    <img src="https://www.arsenal.com${ftlist[9]}" class="card-image"> 
	</div>
  </div>
</div>
<!-- 회원가입, 로그인, 비밀번호 찾기 모달창 -->
<jsp:include page="login.jsp" flush="false" />
<br><br><br>
<!-- footer 페이지 -->
<jsp:include page="footer.jsp" flush="false" />

<script>
/* 예약하기 버튼 실행시 */
function reservation_first() {
		var session = "${sessionScope.email}";
	
		if(session == ""){
			alert("로그인 먼저 해주세요");
		} else {
			var homeimage = "${ftlist[7]}";
			var awayimage = "${ftlist[8]}";
			var home = "${ftlist[4]}";
			var away = "${ftlist[5]}";
			var date = "${ftlist[10]}" +" " + "${ftlist[2]}";
			var stadium = "${ftlist[0]}";
			var address = "reservation.do?homeimage=" + homeimage + "&awayimage=" + awayimage
							+ "&home=" + home + "&away=" + away + "&date=" + date + "&stadium=" + stadium;
			
			window.open(address, "reservation", "left=450 top=40 width=1045 height=825 status=no scrollbars=no");
		}
}

function reservation_second() {
	var session = "${sessionScope.email}";

	if(session == ""){
		alert("로그인 먼저 해주세요");
	} else {
		var homeimage = "${ftlist[7]}";
		var awayimage = "${ftlist[9]}";
		var home = "${ftlist[4]}";
		var away = "${ftlist[6]}";
		var date = "${ftlist[10]}" + " " + "${ftlist[3]}";
		var stadium = "${ftlist[1]}";
		var address = "reservation.do?homeimage=" + homeimage + "&awayimage=" + awayimage
						+ "&home=" + home + "&away=" + away + "&date=" + date + "&stadium=" + stadium;
		
		window.open(address, "reservation", "left=450 top=40 width=1045 height=825 status=no scrollbars=no");
	}
}


</script>
</html>
