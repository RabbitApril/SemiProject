<jsp:include page="/WEB-INF/views/common/common_css_firstline.jsp"/> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<jsp:include page="/WEB-INF/views/common/common_css1.jsp"/> 
<!-- noticeboard section 영역 style -->
<link href="<%=request.getContextPath()%>/resource/css/board.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<div class="wrap">
	<div class="wrap-header">
		<%@include file="/WEB-INF/views/common/header.jsp"%>
	</div>
	<div class="wrap-main">
		<%@include file="/WEB-INF/views/board/noticeboard/noticeboard_section.jsp"%>
		<%@include file="/WEB-INF/views/common/aside.jsp"%>
	</div>
</div>

<script>
$(loadedHandler);
function loadedHandler() {
	// button 이벤트 등록 
	$(".btn.writecontent").on("click", writenotceClickHandler);
}

function writenotceClickHandler() {
	location.href = "${pageContext.request.contextPath}/notice/write"
}
</script>
</body>
</html>