<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="/resources/js/login.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="/resources/css/login.css">
<title>Home</title>
</head>
<body>
<!-- 로그인 모달 -->
<div id="loginModal" class="modal">
  <form class="modal-content animate" action="javascript:login()" id="loginForm">
    <div class="imgcontainer">
      <span onclick="document.getElementById('loginModal').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>
    <div class="container">
      <h1>Login</h1>
      <br><br>
      <label for="Email"><b>Email!</b></label>
      <input type="text" placeholder="Enter Email-address" name="email" id="emailsign" required>
      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="passwd" id="passwdsign" required>
      <button type="button" onclick="login()">Login</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('loginModal').style.display='none'" class="cancelbtn">Cancel</button>
      <button class="buttonforgot" onclick="document.getElementById('loginModal').style.display='none';document.getElementById('pwdfindModal').style.display='block';" style="width:auto;">Forgot password?</button>
    </div>
  </form>
</div>



<!-- 패스워드 찾기 모달 -->
<div id="pwdfindModal" class="modal">
  <form class="modal-content animate" action="/action_page.php" id="pwfindform">
    <div class="imgcontainer">
      <span onclick="document.getElementById('pwdfindModal').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>
    <div class="container">
      <label for="Email"><h1>Forgot Password?</h1></label>
      <br><br>
      <input type="text" placeholder="Enter Email address" name="findemail" required>
      <button type="button" onclick="certification()">Send My Password</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('pwdfindModal').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

<!-- 회원가입 모달 -->
<div id="signupModal" class="modal">
  <span onclick="document.getElementById('signupModal').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content"  id="userRegistForm">
    <div class="container">
      <h1>Sign Up</h1>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <label for="email"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email" required class="email" id="email" oninput="checkId()">
      <label for="name"><b>Name</b></label>
      <input type="text" placeholder="Enter name" name="name" id="name" required>
      <label for="address"><b>Address</b></label>
      <input type="text" placeholder="Enter Address" name="address" id="address" required onclick="setAddr()" readonly>
      <input type="text" placeholder="" name="dt-address" id="dt-address" required>
      <label for="phone"><b>Phone-number</b></label>
      <input type="text" placeholder="Enter phone-number" name="phone" id="phone" required>
      <label for="pswd"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="passwd" required class="pswd" oninput="checkPwd()">
      <label for="psw-repeat"><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" name="psw-repeat"  required class="pswd" id="repwd" oninput="checkPwd()">
      <div class="clearfix">
        <button type="button" class="signupbtn" onclick="join()">Sign Up</button>
      </div>
    </div>
  </form>
</div>

<!-- 업로드 모달 -->
<div id="uploadModal" class="modal">
  <form class="modal-content animate" id="fileForm" action="uploadForm.do" method="post" enctype="multipart/form-data">
    <div class="imgcontainer">
      <span onclick="document.getElementById('uploadModal').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>
    <div class="container">
      <h1>Profile Image</h1>
      <br><br>
      <label for="Email"><b>Profile Image Select</b></label>
      <input type="file" name="file" multiple="multiple" id="imagefile">
    <!--   <input type="file" name="file"> -->
      <button type="button" onclick="upload()">upload</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('uploadModal').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>




</body>

<script type="text/javascript">
//Get the modal
var modal1 = document.getElementById('loginModal');
var modal2 = document.getElementById('signupModal');
var modal3 = document.getElementById('pwdfindModal');
var modal4 = document.getElementById('uploadModal');
window.onclick = function(event) {
    if (event.target == modal1) {
        modal1.style.display = "none";
        location.reload();
    } 
    
    if (event.target == modal3) {
    	modal3.style.display = "none";
        location.reload();
    } 
    
    if (event.target == modal2) {
        modal2.style.display = "none";
        location.reload();
    }
    
    if (event.target == modal4) {
        modal4.style.display = "none";
        location.reload();
    }
    
}
</script>
</html>
