<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    파일이 업로드 되었습니다.
    파일명 : ${savedName}
    
    
    <%-- <img src="${savedImg}"> --%>
    
    <embed src="${savedImg}" autostart="true" loop="false" width="280" height="500" hidden="true">
    
</body>
</html>