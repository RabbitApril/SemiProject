<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>
	<div class="logo">
		<a href="${pageContext.request.contextPath}/main"> <img src="${pageContext.request.contextPath}/resource/img/로그인 이미지.png" alt="로고"
			width="80px" height="80px">
		</a>
	</div>
	<nav class="top menu">
		<ul class="top menu">
			<li class="notice"><a href="${pageContext.request.contextPath}/notice/list">공지사항</a></li>
			<li class="review"><a href="${pageContext.request.contextPath}/review/list">리뷰게시판</a></li>
			<li class="freewrite"><a href="${pageContext.request.contextPath}/community/list">자유게시판</a></li>
			<li class="mypage"><a href="${pageContext.request.contextPath}/mypage">마이 페이지</a></li>
		</ul>
	</nav>
</header>