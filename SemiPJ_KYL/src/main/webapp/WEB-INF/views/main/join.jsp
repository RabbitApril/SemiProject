<jsp:include page="/WEB-INF/views/common/common_css.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<!-- join 영역 style -->
<link href="<%=request.getContextPath()%>/resource/css/join.css" rel="stylesheet">
</head>
<body>
<div class="box container">
	<div class="joinbox">
		<div class="joinImg">
			<img src="${pageContext.request.contextPath}/resource/img/회원가입 이미지.png" alt="가입 이미지" width="120px" height="120px">
		</div>
		<form action="${pageContext.request.contextPath}/join" method="post">
			<div class="writebox">
				<div>
					<label>아이디</label>
					<div class="infoId">
                        <input type="text" name="id" class="chkidbox">
                    	<button type="button" class="btn checkid">중복확인</button>
                    </div>
					<small>Error message</small>
				</div>
				<div>
					<label>닉네임</label>
                    <div class="infoNick">
                        <input type="text" name="nick" class="chknickbox">
                    	<button type="button" class="btn checknickname">중복확인</button>
                    </div>
					<small>Error message</small>
				</div>
				<div>
					<label>비밀번호</label> <input type="password" name="pwd">
					<small>Error message</small>
				</div>
				<div>
					<label>비밀번호 확인</label> <input type="password" name="pwdcheck">
					<small>Error message</small>
				</div>
				<div>
					<label>이메일</label> <input type="email" name="email">
					<small>Error message</small>
				</div>
			</div>
				<div>
					<button type="submit" class="btnjoin">회원가입</button>
				</div>
		</form>
	</div>
</div>
	

	<script>
		$(loadedHandler);
		function loadedHandler() {
			//이벤트 등록
			$(".btn.checkid").on("click", btnCheckidClickHandler);
			$(".btn.checknickname").on("click", btnCheckNicknameClickHandler);
		}
		
// 		id check
		function btnCheckidClickHandler() {
			var idVal = $("[name=id]").val();
			$.ajax({
			url: "${pageContext.request.contextPath}/checkId.ajax"
			, method : "post"
			, data : {cid : $("[name=id]").val(), a1:"v1", a2:"v2" }
			, success : function(result) {
				console.log(result);
				if(result > 0) {
					alert("이미 존재하는 아이디입니다.");
				} else{
					alert("사용 가능한 아이디입니다.");
				}
			}, error:function(request,status,error){
					alert("code: "+request.status + "\n" + "message: " 
							+ request.responseText + "\n"
							+ "error: "+error);
					}
				});
			}

// 		nickname check
		function btnCheckNicknameClickHandler() {
			var idVal = $("[name=nick]").val();
			$.ajax({
				url: "${pageContext.request.contextPath}/checkNickname.ajax"
					, method : "post"
					, data : {cid : $("[name=nick]").val(), b1:"w1", b2:"w2" }
					, success : function(result) {
						console.log(result);
						if(result > 0) {
							alert("이미 존재하는 닉네임입니다.");
						} else{
							alert("사용 가능한 닉네임입니다.");
						}
					}, error:function(request,status,error){
							alert("code: "+request.status + "\n" + "message: " 
									+ request.responseText + "\n"
									+ "error: "+error);
					}
				});
			}
			
// 		회원가입 무결성 체크
		
	</script>
</body>
</html>