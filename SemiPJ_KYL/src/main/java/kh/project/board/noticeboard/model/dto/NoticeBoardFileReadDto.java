package kh.project.board.noticeboard.model.dto;

public class NoticeBoardFileReadDto {
//	BOARD_FILE_ID        NOT NULL NUMBER(20)     
//	NOTICE_ID            NOT NULL NUMBER         
//	ORIGINAL_FILENAME    NOT NULL VARCHAR2(300)  
//	SAVED_FILE_PATH_NAME NOT NULL VARCHAR2(1000) 
	private Integer boardFileId;
	private Integer noticeId;
	private String originalFilename;
	private String savedFilePathName;
	
	@Override
	public String toString() {
		return "NoticeBoardFileReadDto [boardFileId=" + boardFileId + ", noticeId=" + noticeId + ", originalFilename="
				+ originalFilename + ", savedFilePathName=" + savedFilePathName + "]";
	}

	public NoticeBoardFileReadDto(Integer boardFileId, Integer noticeId, String originalFilename,
			String savedFilePathName) {
		super();
		this.boardFileId = boardFileId;
		this.noticeId = noticeId;
		this.originalFilename = originalFilename;
		this.savedFilePathName = savedFilePathName;
	}

	public Integer getBoardFileId() {
		return boardFileId;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public String getSavedFilePathName() {
		return savedFilePathName;
	}
	
}
