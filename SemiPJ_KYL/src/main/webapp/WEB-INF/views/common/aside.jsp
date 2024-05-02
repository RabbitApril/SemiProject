<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<aside>
	<c:choose>
		<c:when test="${empty aceptLogin }">
			<div class="before login">
				<div class="login">
					<input type="button" value="로그인" class="btn login">
				</div>
				<div class="join">
					<input type="button" value="회원가입" class="btn join">
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="after login">
				<div class="profileImg">
					<img src = "${pageContext.request.contextPath}/resource/img/미등록 프로필사진.png" alt="미등록 프로필사진" width = "150px" height="150px">
				</div>
				<div class="name">
					<div class="memNick">아이디</div>
					<div class="gradeicon">
						<img src="" alt="유저구분아이콘">
					</div>
				</div>
				<form id="frm-logout">
					<div>
						<button type="button" class="btn logout">로그아웃</button>
					</div>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
	<hr class="gap1" />
	<div class="eventtable">
		<div class="aside write">
			<button type="button" class="review write">
				<img src="${pageContext.request.contextPath}/resource/img/notes.png"
					alt="서평 남기기" width="30px" height="30px"> 서평 남기기
			</button>
		</div>
		<div class="libraryInfo">
			<a href="https://www.library.kr/cyber/index.do"> <img
				src="${pageContext.request.contextPath}/resource/img/사이버 도서관 로고.png"
				alt="통합자료검색 - 경기도 사이버 도서관" width="180px" height="50px">
			</a>
		</div>
		<div class="SIBF">
			<a href="https://sibf.or.kr/"> <img
				src="${pageContext.request.contextPath}/resource/img/국제도서전 이미지.png"
				alt="서울 국제 도서전" width="180px" height="50px">
			</a>
		</div>
	</div>
</aside>
<script>
$(loadedHandler); 
function loadedHandler() {
	//event 등록 
	$(".btn.login").on("click", btnLoginClickHandler);
	$(".btn.join").on("click", btnJoinClickHandler);
	$(".btn.logout").on("click", btnLogoutClickHandler);
	$(".review.write").on("click",btnReviewWriteClickHandler)
}

function btnLoginClickHandler() {
	location.href="${pageContext.request.contextPath}/login";	
}

function btnJoinClickHandler() {
	location.href="${pageContext.request.contextPath}/join";	
}

function btnLogoutClickHandler() {	
	alert("사이트에서 로그아웃되었습니다.");
	
	var frmlogout = document.getElementById("frm-logout");
	frmlogout.action = "${pageContext.request.contextPath}/logout";
	frmlogout.method = "post";
	frmlogout.submit();
}

function btnReviewWriteClickHandler() {
	location.href="${pageContext.request.contextPath}/review/write";
}
</script>