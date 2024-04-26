<jsp:include page="/WEB-INF/views/common/common_css.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<!-- login 영역 style -->
<link href="<%=request.getContextPath()%>/resource/css/login.css" rel="stylesheet">

</head>

<body>
	<div class="loginWrap">
		<div class="login-inner">
			<div class="loginImg">
				<img
					src="${pageContext.request.contextPath}/resource/img/로그인 이미지.png"
					alt="클릭 시 메인화면으로" width="250px" height="250x" style="cursor: pointer;">
			</div>

			<!-- ajax 방식 -->
			<form id="frm-login">
				<div>
					<label>아이디</label>
                    <input type="text" name="id" class="idwrite" autofocus>
				</div>
				<div>
					<label>비밀번호</label>
                    <input type="password" name="pwd" class="pwdwrite" required>
				</div>
				<div>
					<label class="savepoint">
                        <input type="checkbox" name="saveId" class="chkbox"> 아이디 저장
                    </label>
				</div>
				<div class="buttonlayout">
                    <div class="loginFunction">
                        <div style="cursor: pointer;" class="btn join">회원가입</div>
                        <div style="cursor: pointer;"class="btn find info">아이디/비밀번호 찾기</div>
                    </div>
                    <div class="btn login">
                        <input type="button" value="로그인" class="btn submit" style="cursor: pointer;">
                    </div>
                </div>
			</form>
		</div>
	</div>
	
	<!-- 	쿠키값으로 id정보 받아오기 -->
	<%String cookie = "";
		Cookie[] cookies = request.getCookies(); // 쿠키생성
		if (cookies != null && cookies.length > 0)
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("memId")) { // 쿠키명 찾아서 값 저장
					cookie = cookies[i].getValue();
				}
			}%>

	<script>
		$(loadedHandler);
		function loadedHandler() {
			//button event 등록
			$("#frm-login .btn.submit").on("click", frmClickHandler);
			$("#frm-login .btn.join").on("click", joinClickHandler);
			$("#frm-login .btn.find.info").on("click", findInfoClickHandler);
			$(".loginImg").on("click", backtoMainHandler)
		}

		function joinClickHandler() {
			location.href = "${pageContext.request.contextPath}/join";
		}

		function findInfoClickHandler() {
			location.href = "${pageContext.request.contextPath}/find/memberinfo"
		}
		
		function backtoMainHandler() {
			// 이미지 클릭시 메인으로 돌아가는 event 등록
			location.href = "${pageContext.request.contextPath}/main"
		}
		
		function frmClickHandler() {
			$.ajax({
				url : "${pageContext.request.contextPath }/login",
				method : "post",
				data : $("#frm-login").serialize(),
				success : function(result) {
				console.log(result);
				if (result == 1) {
					var prePage = "${prePage}";
					if (prePage == "write") {
						location.href = "${pageContext.request.contextPath }/community/write";
						} location.href = "${pageContext.request.contextPath }/main";
					} else {
						alert("아이디 또는 패스워드가 일치하지 않습니다. 다시 확인하고 로그인해주세요.");
						$("[name=pwd]").val("");
						}
					},error : function(request, status, error) {
						alert("code: " + request.status + "\n"
							+ "message: " + request.responseText + "\n"
							+ "error: " + error);
					}
			});
		}
	</script>

</body>
</html>