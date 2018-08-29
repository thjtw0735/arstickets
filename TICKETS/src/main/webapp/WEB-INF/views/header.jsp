<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>
<div class="jumbotron">
  <div class="container text-center">
    <h1>Arsenal Tickets </h1>      
    <p></p>
  </div>
</div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
<!--       <a class="navbar-brand" href="#">Logo</a> -->
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><button class="button" onclick="location='main.do'" style="width:auto;"> Home </button><li/>
        <c:if test="${sessionScope.email == null }">
	        <li><button class="button" onclick="document.getElementById('loginModal').style.display='block'" style="width:auto;">Login</button><li/>
        </c:if>
        <c:if test="${sessionScope.email != null }">
        	<c:if test="${imgAddr == null }">
	        	<li><button class="button" onclick="document.getElementById('uploadModal').style.display='block'" style="width:auto; background-size: 80px;"><img src="D:\image\car.jpg">Profile</button><li/>
        	</c:if>
        	<c:if test="${imgAddr != null }">
	        	<%-- <li><button class="button" onclick="document.getElementById('uploadModal').style.display='block'" style="width:auto; background-size: 80px;"><img src="${imgAddr}">Profile</button><li/> --%>
	        	<li><button class="button" onclick="document.getElementById('uploadModal').style.display='block'" style="width:auto; background-size: 80px;"><img src="${imgAddr}">Profile</button><li>
        	</c:if>
	        <li><button class="button" onclick="logout()" style="width:auto;"> Logout </button><li/>
        </c:if>
        <c:if test="${sessionScope.email == null }">
	        <li><button class="button" onclick="document.getElementById('signupModal').style.display='block'" style="width:auto;">Sign Up</button></li>
        </c:if>
        <c:if test="${sessionScope.email != null }">
	        <li><button class="button" onclick="mypage()" style="width:auto;">My page</button><li/>
        </c:if>
      </ul>
    </div>
  </div>
</nav>
</body>
<script>
function mypage() {
	if ( ${sessionScope.email == null} ){
		alert("로그인 먼저 해주세요");
	} else {
		var address = "mypage.do";
		location.replace(address);
	}
}

function logout(){
	alert("로그아웃 되었습니다.");
	var address = "main.do?session=1";
	location.replace(address);
	
	return false;
}

function profileIMG() {
	
	var img = ""
	
}
</script>