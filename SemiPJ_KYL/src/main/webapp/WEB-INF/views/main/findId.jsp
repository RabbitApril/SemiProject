<jsp:include page="/WEB-INF/views/common/common_css2.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<!-- findid 영역 style -->
<link href="<%=request.getContextPath()%>/resource/css/findid.css" rel="stylesheet">

</head>
<body>
	<div class="findidWrap">
		<div class="findid-inner">
			<div class="findid title">
				<img src = "대충이미지넣기" alt = "아이디찾기 이미지"><br>
				아이디 찾기
			</div>
	        <form id="frm-findId">
	            <div>
	                <label>닉네임</label>
	                <input type="text" name="nick">
	            </div>
	            <div>
	                <label>이메일</label>
	                <input type="email" name="email">
	            </div>
	            <div>
	                <input type = "button" value = "아이디 찾기" class = "btn submit">
	                <input type = "button" value = "로그인으로" class = "btn login">
	            </div>
	        </form>
    	</div>
	</div>
    
    <script>
	    $(loadedHandler);
		function loadedHandler() {
			$(".btn.login").on("click",btnBackLogin);
			$(".btn.submit").on("click",btnFindId);
		}
		
		function btnBackLogin() {
			location.href="${pageContext.request.contextPath}/login";
		}
		
		function btnFindId() {
			
		}
    </script>
</body>
</html>