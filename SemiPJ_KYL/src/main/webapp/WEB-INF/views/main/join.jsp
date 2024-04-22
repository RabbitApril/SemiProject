<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<div class="joinbox">
		<div class="joinImg">
			<img src="${pageContext.request.contextPath}/WEB-INF/resource/img/로그인 이미지.png" alt="가입 이미지">
		</div>
		<form class="memberjoin">
			<div>
				<label>아이디</label> <input type="text" name="id">
				<button type="button" class="btn checkid">중복확인</button>
			</div>
			<div>
				<label>닉네임</label> <input type="text" name="nick">
				<button type="button" class="btn checknickname">중복확인</button>
			</div>
			<div>
				<label>비밀번호</label> <input type="password" name="pwd">
			</div>
			<div>
				<label>비밀번호 확인</label> <input type="password" name="pwdcheck">
			</div>
			<div>
				<label>이메일</label> <input type="email" name="email">
			</div>
			<div>
				<button type="submit">회원가입</button>
			</div>
		</form>
	</div>

	<script>
		$(loadedHandler);
		function loadedHandler() {
			//이벤트 등록
			$(".btn.checkid").on("click", btnCheckidClickHandler);
			$(".btn.checknickname").on("click", btnCheckemailClickHandler)
		}

		function btnCheckidClickHandler() {
			$.ajax({
			url:
			, method : 
			, data : 
			, success : function(result) {
				console.log(result);
				if(result > 0) {
					alert("이미 존재하는 아이디입니다.");
				} else {
					
				}
				, error:function(request,status,error){
					alert("code: "+request.status + "\n" + "message: " 
							+ request.responseText + "\n"
							+ "error: "+error);
					}
			}
			});
		}

		function btnCheckemailClickHandler() {
			$.ajax({
				url:
					, method : 
					, data : 
					, success : function(result) {
						console.log(result);
						if(result > 0) {
							alert("이미 존재하는 닉네임입니다.");
						} else {
							
						}
						, error:function(request,status,error){
							alert("code: "+request.status + "\n" + "message: " 
									+ request.responseText + "\n"
									+ "error: "+error);
							}
			});
		}
	</script>
</body>
</html>