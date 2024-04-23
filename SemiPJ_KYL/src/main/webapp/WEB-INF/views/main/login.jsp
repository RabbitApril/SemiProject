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
	<div class="box container">
		<div class="loginbox">
			<div class="loginImg">
				<img
					src="${pageContext.request.contextPath}/resource/img/로그인 이미지.png"
					alt="로그인 이미지">
			</div>

			<!-- ajax 방식 -->
			<form id="frm-login">
				<div>
					<label>아이디</label>
                    <input type="text" name="id" class="idwrite" autofocus>
				</div>
				<div>
					<label>비밀번호</label>
                    <input type="password" name="pwd" class="pwdwrite" autofocus>
				</div>
				<div>
					<label class="savepoint">
                        <input type="checkbox" name="saveId" class="chkbox"> 아이디 저장
                    </label>
				</div>
				<div class="buttonlayout">
                    <div class="loginFunction">
                        <div class="join">회원가입</div>
                        <div class="find info">아이디/비밀번호 찾기</div>
                    </div>
                    <div class="btn login">
                        <input type="button" value="로그인" class="btn submit">
                    </div>
                </div>
			</form>
		</div>
	</div>
	<!-- 	쿠키값으로 id정보 받아오기 -->
	<%
	String cookie = "";
	Cookie[] cookies = request.getCookies(); // 쿠키생성
	if (cookies != null && cookies.length > 0)
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("memId")) { // 쿠키명 찾아서 값 저장
		cookie = cookies[i].getValue();
			}
		}
	%>


	<script>
		$(loadedHandler);
		function loadedHandler() {
			//button event 등록
			$("#frm-login .btn.submit").on("click", frmClickHandler);
			$("#frm-login .btn.join").on("click", joinClickHandler);
			$("#frm-login .btn.find.info").on("click", findInfoClickHandler);
		}

		function joinClickHandler() {
			location.href = "${pageContext.request.contextPath}/join";
		}

		function findInfoClickHandler() {
			location.href = "${pageContext.request.contextPath}/find/memberinfo"
		}

		function frmClickHandler() {
			$
					.ajax({
						url : "${pageContext.request.contextPath }/login",
						method : "post",
						data : $("#frm-login").serialize(),
						success : function(result) {
							console.log(result);
							if (result == 1) {
								var prePage = "${prePage}";
								if (prePage == "write") {
									location.href = "${pageContext.request.contextPath }/community/write";
								}
								location.href = "${pageContext.request.contextPath }/main";
							} else {
								alert("아이디 또는 패스워드가 일치하지 않습니다. 다시 확인하고 로그인해주세요.");
								$("[name=pwd]").val("");
							}
						},
						error : function(request, status, error) {
							alert("code: " + request.status + "\n"
									+ "message: " + request.responseText + "\n"
									+ "error: " + error);
						}
					});

		}
	</script>

</body>
</html>