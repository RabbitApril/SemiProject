<jsp:include page="/WEB-INF/views/common/common_css_firstline.jsp"/> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>

<jsp:include page="/WEB-INF/views/common/common_css1.jsp"/> 
<!-- freeboardRead section 영역 style -->
<link href="<%=request.getContextPath()%>/resource/css/boardread.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/common/common_function.jsp" />
</head>
<body>
	<div class="wrap">
	<div class="wrap-header">
		<%@include file="/WEB-INF/views/common/header.jsp"%>
	</div>
	<div class="wrap-main">
		<%@include file="/WEB-INF/views/board/freeboard/freeboardRead_section.jsp"%>
		<%@include file="/WEB-INF/views/common/aside.jsp"%>
	</div>
</div>
</body>
</html>