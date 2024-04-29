<jsp:include page="/WEB-INF/views/common/common_css2.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<!-- findpwd 영역 style -->
<link href="<%=request.getContextPath()%>/resource/css/findpwd.css" rel="stylesheet">
</head>
<body>
	<div class="findpwdWrap">
		<div class="findpwd-inner">
			<div class="findpwd title">
				<img src = "대충이미지넣기" alt = "비밀번호찾기 이미지"><br>
				비밀번호 찾기
			</div>
	        <form id="frm-findId">
	            <div>
	                <label>아이디</label>
	                <input type="text" name="id">
	            </div>
	            <div>
	                <label>이메일</label>
	                <input type="email" name="email">
	            </div>
	            <div>
	                <input type = "button" value = "비밀번호 찾기" class = "btn submit">
	                <input type = "button" value = "로그인으로" class = "btn login">
	            </div>
	        </form>
    	</div>
	</div>
    
    <script>
    	$(loadedHandler);
    	function loadedHandler() {
    		$(".btn.login").on("click",btnBackLogin);
    		$(".btn.submit").on("click",btnFindPassword);
    	}
    	
    	function btnBackLogin() {
    		location.href="${pageContext.request.contextPath}/login";
    	}
    	
    	function btnFindPassword() {
    		
    	}
    </script>
</body>
</html>