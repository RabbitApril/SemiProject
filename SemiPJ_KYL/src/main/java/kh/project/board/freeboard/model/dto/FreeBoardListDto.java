package kh.project.board.freeboard.model.dto;

public class FreeBoardListDto {
//	BOARD_ID      NOT NULL NUMBER         
//	BOARD_TITLE   NOT NULL VARCHAR2(120)  
//	BOARD_CONTENT NOT NULL VARCHAR2(4000) 
//	WRITE_TIME    NOT NULL TIMESTAMP(6)   
//	READ_COUNT    NOT NULL NUMBER         
//	READ_GOOD     NOT NULL NUMBER         
//	MEM_ID        NOT NULL VARCHAR2(20)
	private Integer boardId;
	private String boardTitle;
	private String boardContent;
	private String writeTime; //TIMESTAMP
	private Integer readCount;
	private Integer readGood;
	private String memId;
	
	@Override
	public String toString() {
		return "FreeBoardListDto [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", writeTime=" + writeTime + ", readCount=" + readCount + ", readGood=" + readGood + ", memId="
				+ memId + "]";
	}

	public FreeBoardListDto() {
		super();
	}

	public FreeBoardListDto(Integer boardId, String boardTitle, String boardContent, String writeTime,
			Integer readCount, Integer readGood, String memId) {
		super();
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.writeTime = writeTime;
		this.readCount = readCount;
		this.readGood = readGood;
		this.memId = memId;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public String getWriteTime() {
		return writeTime;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public Integer getReadGood() {
		return readGood;
	}

	public String getMemId() {
		return memId;
	}
	
}
