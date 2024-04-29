<!-- 부트스트랩 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- 부트스트랩 JSP -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        
<jsp:include page="/WEB-INF/views/common/common_css1.jsp"/> 
       
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cat in the box</title>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

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

</body>
</html>