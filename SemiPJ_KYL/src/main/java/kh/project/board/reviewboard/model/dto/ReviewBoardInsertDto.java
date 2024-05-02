package kh.project.board.reviewboard.model.dto;

import java.util.List;

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
	private List<ReviewBoardFileWriteDto> fileList;
	
	@Override
	public String toString() {
		return "ReviewBoardInsertDto [reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent + ", memId="
				+ memId + ", fileList=" + fileList + "]";
	}
	
	public ReviewBoardInsertDto(String reviewTitle, String reviewContent, String memId,
			List<ReviewBoardFileWriteDto> fileList) {
		super();
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.memId = memId;
		this.fileList = fileList;
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
	
	public List<ReviewBoardFileWriteDto> getFileList() {
		return fileList;
	}
}
