<jsp:include page="/WEB-INF/views/common/common_css.jsp"/>
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
<div class="wrap">
	<div class="wrap-header">
		<%@include file="/WEB-INF/views/common/header.jsp"%>
	</div>
	<div class="wrap-main">
	</div>
</div>
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