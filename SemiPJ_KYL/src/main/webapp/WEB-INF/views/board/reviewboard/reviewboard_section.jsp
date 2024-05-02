<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section>
	<div class="title1">리뷰 게시판</div>
	<hr class="gap1">
	<div class="noticeboard grid top">
		<div class="searchform">
			<form id="frm-searchform" class="searchcontent">
				<select name="search">
					<option value="n01">제목</option>
					<option value="n01">작성자</option>
				</select>
				<div class="searchnkeyword">
					<input type="text" class="keyword">
					<button type="submit" class="btn submitkeyword">검색</button>
				</div>
			</form>
		</div>
		<div>
			<button type="button" class="btn writecontent">글쓰기</button>
		</div>
	</div>
	<div class="board grid">
		<div>번호</div>
		<div>제목</div>
		<div>작성자</div>
		<div>작성일</div>
		<div>조회수</div>
	</div>
	<hr class="line1">
	<div class="boardcontent grid">
		<!-- 내용 -->
		<div>내용확인용 번호</div>
		<div>내용확인용</div>
		<div>내용확인용</div>
		<div>내용확인용</div>
		<div>내용확인용</div>
		<!-- <div>아직 작성된 글이 없어요.</div> -->
	</div>
	<div class="pageNumLink">
		<ul>
			<li>1</li>
		</ul>
	</div>
</section>