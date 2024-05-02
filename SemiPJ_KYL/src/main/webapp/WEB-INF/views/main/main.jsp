<jsp:include page="/WEB-INF/views/common/common_css_firstline.jsp"/> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cat in the box</title>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<!-- 부트스트랩 CSS -->
<link href="${pageContext.request.contextPath }/resource/bootstrap-5.3.3-dist/css/bootstrap.min.css" rel="stylesheet">

<jsp:include page="/WEB-INF/views/common/common_css1.jsp"/> 
<!-- main section 영역 style -->
<link href="<%=request.getContextPath()%>/resource/css/main.css" rel="stylesheet">

</head>

<body>
<div class="wrap">
	<div class="wrap-header">
		<%@include file="/WEB-INF/views/common/header.jsp"%>
	</div>
	<div class="wrap-main">
		<%@include file="/WEB-INF/views/main/main_section.jsp"%>
		<%@include file="/WEB-INF/views/common/aside.jsp"%>
	</div>
</div>

<!-- 부트스트랩 JSP -->

<script src="${pageContext.request.contextPath }/resource/bootstrap-5.3.3-dist/js/bootstrap.js"></script>
</body>
</html>