var idCheck = 0;
var pwdCheck = 0;

// 회원가입 시 id 체크
function checkId() {
    var inputed = $('.email').val();
    $.ajax({
        data : {
            email : inputed
        },
        url : "checkId.do",
        success : function(data) {
            if(inputed=="" && data=='0') {
                $(".signupbtn").prop("disabled", true);
                $(".signupbtn").css("background-color", "#aaaaaa");
                $("#email").css("background-color", "#FFCECE");
                idCheck = 0;
            } else if (data == '0') {
                $("#email").css("background-color", "#B0F6AC");
                idCheck = 1;
                if(idCheck==1 && pwdCheck == 1) {
                    $(".signupbtn").prop("disabled", false);
                    $(".signupbtn").css("background-color", "#4CAF50");
                    signupCheck();
                }
        	} else if (data == '1') {
                $(".signupbtn").prop("disabled", true);
                $(".signupbtn").css("background-color", "#aaaaaa");
                $("#email").css("background-color", "#FFCECE");
                idCheck = 0;
            } 
        } , error:function(request,status,error){
	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		  }
    });
}

// 비밀번호 같은지 체크. 같을 경우에만 가입버튼 활성화
function checkPwd() {
    var inputed = $('.pswd').val();
    var reinputed = $('#repwd').val();
    if(reinputed=="" && (inputed != reinputed || inputed == reinputed)){
        $(".signupbtn").prop("disabled", true);
        $(".signupbtn").css("background-color", "#aaaaaa");
        $("#repwd").css("background-color", "#FFCECE");
    } else if (inputed == reinputed) {
        $("#repwd").css("background-color", "#B0F6AC");
        pwdCheck = 1;
        if(idCheck==1 && pwdCheck == 1) {
            $(".signupbtn").prop("disabled", false);
            $(".signupbtn").css("background-color", "#4CAF50");
            signupCheck();
        }
    } else if (inputed != reinputed) {
        pwdCheck = 0;
        $(".signupbtn").prop("disabled", true);
        $(".signupbtn").css("background-color", "#aaaaaa");
        $("#repwd").css("background-color", "#FFCECE");
        
    }
}

//닉네임과 이메일 입력하지 않았을 경우 가입버튼 비활성화
function signupCheck() {
    var address = $("#address").val();
    var phone = $("#phone").val();
    if(address=="" || phone=="") {
        $(".signupbtn").prop("disabled", true);
        $(".signupbtn").css("background-color", "#aaaaaa");
    } else {
    }
}

// 회원가입 정보 db에 insert
function join() {
	$.ajax({
		  method: "POST",
		  url: "signup.do",
		  data: $("#userRegistForm").serialize(),
		  dataType: "text",
		  success:function(map){
			  if(map == 1000){
				  alert("회원가입이 완료되었습니다.");
				  location.reload();				  
			  }else{
				  alert("회원가입에 실패하였습니다. 다시 시도해 주시기 바랍니다.");
				  location.reload();
				  
			  }
		  },
		  error:function(request,status,error){
		        /*alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);*/
		  }
		})
}


// 우편번호 찾기
function setAddr() {
	var width = 500;
	var height = 600;
	daum.postcode.load(function(){
		new daum.Postcode({
			oncomplete: function( data ) {
				$("#address").val(data.roadAddress);
			}	
		}).open({
			left: (window.screen.width/2 ) - ( width/2 ),
			top: (window.screen.height/2 ) - ( height/2 ) 
		});
	});
}

// 로그인 하기
function login(){
	if($('#emailsign').val() ==""){
		alert("아이디를 입력해주세요");
		return;
	}
	
	if($('#passwdsign').val() ==""){
		alert("비밀번호를 입력해주세요");
		return;
	}
	
	$.ajax({
		  method: "POST",
		  url: "login.do",
		  data: $("#loginForm").serialize(),
		  dataType: "text",
		  success : function(data){
			  if(data == "0"){
				  alert("아이디나 비밀번호가 올바르지 않습니다. 다시 시도해 주시기 바랍니다.");				  
			  }else{
				  var address="main.do";
				  location.replace(address);
			  }
		  },
		  error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		  }
		})
}

//이미지 업로드하기
function upload(){

	var formData = new FormData();
	
	var filesArr = Array.prototype.slice.call($("#imagefile")[0].files);
	for ( var i=0; i < filesArr.length; i++){
		formData.append("image_"+i , filesArr[i]);
	}
	
	$.ajax({
          type: 'POST',
		  url: "uploadForm.do",
		  data: formData,
		  processData : false,
          contentType : false,
		  success : function(data){
			  if(data == "1"){
				  
			  }else{
				  var address="main.do";
				  location.replace(address);
			  }
		  },
		  error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		  }
		})
		/*
		$("#uploadForm").submit();*/
}


// 비밀번호 찾기 이메일 인증
function certification(){
    $.ajax({
		  method: "POST",
		  url: "certification.do",
		  data: $("#pwfindform").serialize(),
		  dataType: "text",
		  success : function(data){
			  if(data == "0"){
				  alert("입력하신 이메일로 비밀번호가 전송되었습니다.");
				  location.replace("main.do");
			  }else{
				  alert("해당 이메일로 가입한 내역이 없습니다. 이메일 주소를 다시 확인 해주세요");
			  }
		  },
		  error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		  }
		})
}
