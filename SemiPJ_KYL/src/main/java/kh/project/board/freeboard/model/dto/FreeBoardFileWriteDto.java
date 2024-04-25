package kh.project.board.freeboard.model.dto;

public class FreeBoardFileWriteDto {
//	BOARD_FILE_ID        NOT NULL NUMBER(20)     
//	BOARD_ID             NOT NULL NUMBER         
//	ORIGINAL_FILENAME    NOT NULL VARCHAR2(300)  
//	SAVED_FILE_PATH_NAME NOT NULL VARCHAR2(1000) 
	private String originalFilename;
	private String SavedFilePathName;
	
	@Override
	public String toString() {
		return "FreeBoardFileWriteDto [originalFilename=" + originalFilename + ", SavedFilePathName="
				+ SavedFilePathName + "]";
	}

	public FreeBoardFileWriteDto(String originalFilename, String savedFilePathName) {
		super();
		this.originalFilename = originalFilename;
		SavedFilePathName = savedFilePathName;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public String getSavedFilePathName() {
		return SavedFilePathName;
	}
	
}
