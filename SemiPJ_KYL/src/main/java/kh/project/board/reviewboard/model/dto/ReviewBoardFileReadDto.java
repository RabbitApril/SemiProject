package kh.project.board.reviewboard.model.dto;

public class ReviewBoardFileReadDto {
//	BOARD_FILE_ID        NOT NULL NUMBER(20)     
//	REVIEW_ID            NOT NULL NUMBER         
//	ORIGINAL_FILENAME    NOT NULL VARCHAR2(300)  
//	SAVED_FILE_PATH_NAME NOT NULL VARCHAR2(1000) 
	private Integer boardFileId;
	private Integer reviewId;
	private String originalFilename;
	private String savedFilePathName;
	
	@Override
	public String toString() {
		return "ReviewBoardFileReadDto [boardFileId=" + boardFileId + ", reviewId=" + reviewId + ", originalFilename="
				+ originalFilename + ", savedFilePathName=" + savedFilePathName + "]";
	}

	public ReviewBoardFileReadDto(Integer boardFileId, Integer reviewId, String originalFilename,
			String savedFilePathName) {
		super();
		this.boardFileId = boardFileId;
		this.reviewId = reviewId;
		this.originalFilename = originalFilename;
		this.savedFilePathName = savedFilePathName;
	}

	public Integer getBoardFileId() {
		return boardFileId;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public String getSavedFilePathName() {
		return savedFilePathName;
	}
	
}
