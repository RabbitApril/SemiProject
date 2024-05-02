package kh.project.board.freeboard.model.dto;

import java.util.List;

public class FreeBoardInsertDto {
//	BOARD_ID      NOT NULL NUMBER         
//	BOARD_TITLE   NOT NULL VARCHAR2(120)  
//	BOARD_CONTENT NOT NULL VARCHAR2(4000) 
//	WRITE_TIME    NOT NULL TIMESTAMP(6)   
//	READ_COUNT    NOT NULL NUMBER         
//	READ_GOOD     NOT NULL NUMBER         
//	MEM_ID        NOT NULL VARCHAR2(20)
	private String boardTitle;
	private String boardContent;
	private String memId;
	private List<FreeBoardFileWriteDto> fileList;
	
	@Override
	public String toString() {
		return "FreeBoardInsertDto [boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", memId=" + memId
				+ ", fileList=" + fileList + "]";
	}

	public FreeBoardInsertDto(String boardTitle, String boardContent, String memId,
			List<FreeBoardFileWriteDto> fileList) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memId = memId;
		this.fileList = fileList;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public String getMemId() {
		return memId;
	}
	
	public List<FreeBoardFileWriteDto> getFileList() {
		return fileList;
	}
}
