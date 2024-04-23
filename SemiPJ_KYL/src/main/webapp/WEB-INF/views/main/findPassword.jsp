<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<div class="findPasswordbox">
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
                <input type = "button" value = "로그인창으로 돌아가기" class = "btn login">
            </div>
        </form>
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