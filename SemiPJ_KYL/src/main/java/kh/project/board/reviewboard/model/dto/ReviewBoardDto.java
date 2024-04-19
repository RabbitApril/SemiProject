package kh.project.board.reviewboard.model.dto;

public class ReviewBoardDto {
//	REVIEW_ID      NOT NULL NUMBER         
//	REVIEW_TITLE   NOT NULL VARCHAR2(120)  
//	REVIEW_CONTENT NOT NULL VARCHAR2(4000) 
//	REVIEW_TIME    NOT NULL TIMESTAMP(6)   
//	REVIEW_COUNT   NOT NULL NUMBER         
//	REVIEW_GOOD    NOT NULL NUMBER         
//	MEM_ID         NOT NULL VARCHAR2(20)   
	private Integer reviewId;
	private String reviewTitle;
	private String reviewContent;
	private String reviewTime; //TIMESTAMP
	private Integer reviewCount;
	private Integer reviewGood;
	private String memId;
	
	@Override
	public String toString() {
		return "ReviewBoardDto [reviewId=" + reviewId + ", reviewTitle=" + reviewTitle + ", reviewContent="
				+ reviewContent + ", reviewTime=" + reviewTime + ", reviewCount=" + reviewCount + ", reviewGood="
				+ reviewGood + ", memId=" + memId + "]";
	}

	public ReviewBoardDto() {
		super();
	}

	public ReviewBoardDto(Integer reviewId, String reviewTitle, String reviewContent, String reviewTime,
			Integer reviewCount, Integer reviewGood, String memId) {
		super();
		this.reviewId = reviewId;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewTime = reviewTime;
		this.reviewCount = reviewCount;
		this.reviewGood = reviewGood;
		this.memId = memId;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public String getReviewTime() {
		return reviewTime;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public Integer getReviewGood() {
		return reviewGood;
	}

	public String getMemId() {
		return memId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public void setReviewGood(Integer reviewGood) {
		this.reviewGood = reviewGood;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}
	
}
