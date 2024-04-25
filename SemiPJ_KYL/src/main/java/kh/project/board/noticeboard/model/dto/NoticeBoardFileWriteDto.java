package kh.project.board.noticeboard.model.dto;

public class NoticeBoardFileWriteDto {
//	BOARD_FILE_ID        NOT NULL NUMBER(20)     
//	NOTICE_ID            NOT NULL NUMBER         
//	ORIGINAL_FILENAME    NOT NULL VARCHAR2(300)  
//	SAVED_FILE_PATH_NAME NOT NULL VARCHAR2(1000) 
	private String originalFilename;
	private String savedFilePathName;
	
	@Override
	public String toString() {
		return "NoticeBoardFileWriteDto [originalFilename=" + originalFilename + ", savedFilePathName="
				+ savedFilePathName + "]";
	}

	public NoticeBoardFileWriteDto(String originalFilename, String savedFilePathName) {
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
