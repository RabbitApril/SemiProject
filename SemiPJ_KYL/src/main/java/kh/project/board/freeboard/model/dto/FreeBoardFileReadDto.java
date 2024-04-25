package kh.project.board.freeboard.model.dto;

public class FreeBoardFileReadDto {
//	BOARD_FILE_ID        NOT NULL NUMBER(20)     
//	BOARD_ID             NOT NULL NUMBER         
//	ORIGINAL_FILENAME    NOT NULL VARCHAR2(300)  
//	SAVED_FILE_PATH_NAME NOT NULL VARCHAR2(1000) 
	private Integer boardFileId;
	private Integer boardId;
	private String originalFilename;
	private String SavedFilePathName;
	
	@Override
	public String toString() {
		return "FreeBoardFileReadDto [boardFileId=" + boardFileId + ", boardId=" + boardId + ", originalFilename="
				+ originalFilename + ", SavedFilePathName=" + SavedFilePathName + "]";
	}

	public FreeBoardFileReadDto(Integer boardFileId, Integer boardId, String originalFilename,
			String savedFilePathName) {
		super();
		this.boardFileId = boardFileId;
		this.boardId = boardId;
		this.originalFilename = originalFilename;
		SavedFilePathName = savedFilePathName;
	}

	public Integer getBoardFileId() {
		return boardFileId;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public String getSavedFilePathName() {
		return SavedFilePathName;
	}
	
}
