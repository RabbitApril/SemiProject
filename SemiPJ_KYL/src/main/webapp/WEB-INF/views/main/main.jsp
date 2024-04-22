<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cat in the box</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
[[ ${aceptLogin }]] <br>
[[ <%=session.getAttribute("aceptLogin") %>]]
<div><button class="btn login">테스트용 버튼</button></div>
<script>
$(loadedHandler); 
function loadedHandler() {
	//event 등록 
	$(".btn.login").on("click", btnLoginClickHandler);
}

function btnLoginClickHandler() {
	location.href="${pageContext.request.contextPath}/login";	
}
</script>
</body>
</html>