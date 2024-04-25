package kh.project.board.reviewboard.model.dto;

import java.util.List;

public class ReviewBoardReadDto {
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
	private List<ReviewBoardFileReadDto> filedtolist;
	@Override
	public String toString() {
		return "ReviewBoardReadDto [reviewId=" + reviewId + ", reviewTitle=" + reviewTitle + ", reviewContent="
				+ reviewContent + ", reviewTime=" + reviewTime + ", reviewCount=" + reviewCount + ", reviewGood="
				+ reviewGood + ", memId=" + memId + ", filedtolist=" + filedtolist + "]";
	}
	
	
}
