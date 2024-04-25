package kh.project.board.reviewboard.model.dto;

public class ReviewBoardInsertDto {
//	REVIEW_ID      NOT NULL NUMBER         
//	REVIEW_TITLE   NOT NULL VARCHAR2(120)  
//	REVIEW_CONTENT NOT NULL VARCHAR2(4000) 
//	REVIEW_TIME    NOT NULL TIMESTAMP(6)   
//	REVIEW_COUNT   NOT NULL NUMBER         
//	REVIEW_GOOD    NOT NULL NUMBER         
//	MEM_ID         NOT NULL VARCHAR2(20)  
	private String reviewTitle;
	private String reviewContent;
	private String memId;
	
	@Override
	public String toString() {
		return "ReviewBoardInsertDto [reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent + ", memId="
				+ memId + "]";
	}
	
	public ReviewBoardInsertDto(String reviewTitle, String reviewContent, String memId) {
		super();
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.memId = memId;
	}
	
	public String getReviewTitle() {
		return reviewTitle;
	}
	
	public String getReviewContent() {
		return reviewContent;
	}
	
	public String getMemId() {
		return memId;
	}
	
}
