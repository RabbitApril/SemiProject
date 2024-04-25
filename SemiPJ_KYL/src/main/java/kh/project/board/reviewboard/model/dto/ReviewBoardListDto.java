package kh.project.board.reviewboard.model.dto;

public class ReviewBoardListDto {
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
		return "ReviewBoardListDto [reviewId=" + reviewId + ", reviewTitle=" + reviewTitle + ", reviewContent="
				+ reviewContent + ", reviewTime=" + reviewTime + ", reviewCount=" + reviewCount + ", reviewGood="
				+ reviewGood + ", memId=" + memId + "]";
	}

	public ReviewBoardListDto() {
		super();
	}

	public ReviewBoardListDto(Integer reviewId, String reviewTitle, String reviewContent, String reviewTime,
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
	
}
