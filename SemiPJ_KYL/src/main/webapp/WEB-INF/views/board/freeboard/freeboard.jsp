<jsp:include page="/WEB-INF/views/common/common_css1.jsp"/> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>

<!-- freeboard section 영역 style -->
<link href="<%=request.getContextPath()%>/resource/css/board.css" rel="stylesheet">

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
</body>
</html>