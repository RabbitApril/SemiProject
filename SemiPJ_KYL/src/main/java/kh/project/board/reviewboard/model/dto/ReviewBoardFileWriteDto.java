package kh.project.board.reviewboard.model.dto;

public class ReviewBoardFileWriteDto {
//	BOARD_FILE_ID        NOT NULL NUMBER(20)     
//	REVIEW_ID            NOT NULL NUMBER         
//	ORIGINAL_FILENAME    NOT NULL VARCHAR2(300)  
//	SAVED_FILE_PATH_NAME NOT NULL VARCHAR2(1000) 
	private String originalFilename;
	private String savedFilePathName;
	
	@Override
	public String toString() {
		return "ReviewBoardFileWriteDto [originalFilename=" + originalFilename + ", savedFilePathName="
				+ savedFilePathName + "]";
	}

	public ReviewBoardFileWriteDto(String originalFilename, String savedFilePathName) {
		super();
		this.originalFilename = originalFilename;
		this.savedFilePathName = savedFilePathName;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public String getSavedFilePathName() {
		return savedFilePathName;
	}
	
}
