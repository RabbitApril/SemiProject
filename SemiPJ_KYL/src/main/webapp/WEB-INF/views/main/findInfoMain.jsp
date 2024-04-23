<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<div class="findinfobox">
        <div role=”button” class="btn findid">
            <img src="" alt="아이디찾기" class="findidImg">
            아이디찾기
        </div>
        <div role=”button” class="btn findpassword" class="findpasswordImg">
            <img src="" alt="비밀번호 찾기">
            비밀번호 찾기
        </div>
    </div>
</body>

<script>
$(loadedHandler)
function loadedHandler() {
	$(".btn.findid").on("click", btnfindidClickHandler);
	$(".btn.findpassword").on("click", btnfindpasswordClickHandler);
}

function btnfindidClickHandler() {
	location.href="${pageContext.request.contextPath}/findid";
}

function btnfindpasswordClickHandler() {
	location.href="${pageContext.request.contextPath}/findpassword";
}
</script>
</html>