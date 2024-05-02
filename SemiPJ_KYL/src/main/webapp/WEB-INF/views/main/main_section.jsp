<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section>
	<div class="title1">포트폴리오</div>
	<div class="portfolio">
		<!-- 부트스트랩 사용 캐러셀. 이미지는 받아서 넣을것 -->
		<div id="carouselExampleIndicators" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active" data-bs-interval="10000">
					<img
						src="${pageContext.request.contextPath}/resource/img/포트폴리오1.png"
						class="d-block w-100" alt="이벤트1" height="400px">
				</div>
				<div class="carousel-item" data-bs-interval="2000">
					<img src="${pageContext.request.contextPath}/resource/img/루즈 앤 레시온_최종.png" class="d-block w-100"
						alt="이벤트2" height="400px">
				</div>
				<div class="carousel-item">
					<img src="https://picsum.photos/200/300" class="d-block w-100"
						alt="이벤트3" height="400px">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>
	<div class="mainmenu">
		<div class="notice article">
			<a href="Noticeboard.html">공지사항</a>
			<hr>
			(목록 들어가는 곳)
		</div>
		<div class="resent review">
			<a href="Reviewboard.html">최근 리뷰</a>
			<hr>
			(목록 들어가는 곳)
		</div>
	</div>
</section>