<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<header>
	<div class="headerlist">
		<div class="notice">
			<a href="${pageContext.request.contextPath}/notice/list">공지사항</a>
		</div>
		<div class="review">
			<a href="${pageContext.request.contextPath}/review/list">리뷰게시판</a>
		</div>
		<div class="mainhome">
			<img scr="${pageContext.request.contextPath}/main" alt="메인화면 아이콘">
		</div>
		<div class="freewrite">
			<a href="${pageContext.request.contextPath}/community/list">자유게시판</a>
		</div>
		<div class="mypage">
			<a href="${pageContext.request.contextPath}/mypage">마이 페이지</a>
		</div>
	</div>
</header>