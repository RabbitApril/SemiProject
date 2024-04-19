<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<div class="loginbox">
		<div>
			<img src="https://picsum.photos/200/300" alt="로그인 이미지">
		</div>
		<!-- ajax 방식 -->
		<form id="frm-login">
			<div>
				<label>아이디</label><input type="text" name="id">
			</div>
			<div>
				<label>비밀번호</label><input type="text" name="pwd">
			</div>
			<div>
				<label>아이디 저장</label><input type="checkbox" name="saveId">
			</div>
			<div class="loginFunction">
				<div class="join">회원가입</div>
				<div class="find info">아이디/비밀번호 찾기</div>
			</div>
			<div class="btn login">
				<input type="button" value="로그인" class="btn submit">
			</div>
		</form>
	</div>

	<script>
		$(loadedHandler);
		function loadedHandler() {
			//button event 등록
			$("#frm-login .btn.submit").on("click", frmClickHandler);
		}

		function frmClickHandler() {
			$.ajax({
				
			});
		}
	</script>
</body>
</html>