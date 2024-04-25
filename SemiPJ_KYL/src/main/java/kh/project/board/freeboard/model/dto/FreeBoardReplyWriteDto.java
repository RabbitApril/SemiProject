package kh.project.board.freeboard.model.dto;

public class FreeBoardReplyWriteDto {
//	BOARD_REPLY_ID      NOT NULL NUMBER         
//	BOARD_ID            NOT NULL NUMBER         
//	BOARD_REPLY_CONTENT NOT NULL VARCHAR2(4000) 
//	BOARD_REPLY_LOG_IP           VARCHAR2(15)   
//	BOARD_REPLY_LEVEL   NOT NULL NUMBER(2)      
//	BOARD_REPLY_REF     NOT NULL NUMBER         
//	BOARD_REPLY_STEP    NOT NULL NUMBER(3)      
//	MEM_ID              NOT NULL VARCHAR2(20)   
	private Integer boardReplyId;
	private Integer boardId;
	private String memId;
	private String boardReplyContent;
	private String boardReplyLogIp;
	
	@Override
	public String toString() {
		return "FreeBoardReplyWriteDto [boardReplyId=" + boardReplyId + ", boardId=" + boardId + ", memId=" + memId
				+ ", boardReplyContent=" + boardReplyContent + ", boardReplyLogIp=" + boardReplyLogIp + "]";
	}

	public FreeBoardReplyWriteDto(Integer boardReplyId, Integer boardId, String memId, String boardReplyContent,
			String boardReplyLogIp) {
		super();
		this.boardReplyId = boardReplyId;
		this.boardId = boardId;
		this.memId = memId;
		this.boardReplyContent = boardReplyContent;
		this.boardReplyLogIp = boardReplyLogIp;
	}

	public Integer getBoardReplyId() {
		return boardReplyId;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public String getMemId() {
		return memId;
	}

	public String getBoardReplyContent() {
		return boardReplyContent;
	}

	public String getBoardReplyLogIp() {
		return boardReplyLogIp;
	}
	
}
