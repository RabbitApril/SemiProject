package kh.project.board.freeboard.model.dto;

public class FreeBoardReplyListDto {
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
	private String boardReplyContent;
	private String boardReplyLogIp;
	private Integer boardReplyLevel;
	private Integer boardReplyRef;
	private Integer BoardReplyStep;
	private String memId;
	
	@Override
	public String toString() {
		return "FreeBoardReplyListDto [boardReplyId=" + boardReplyId + ", boardId=" + boardId + ", boardReplyContent="
				+ boardReplyContent + ", boardReplyLogIp=" + boardReplyLogIp + ", boardReplyLevel=" + boardReplyLevel
				+ ", boardReplyRef=" + boardReplyRef + ", BoardReplyStep=" + BoardReplyStep + ", memId=" + memId + "]";
	}

	public FreeBoardReplyListDto(Integer boardReplyId, Integer boardId, String boardReplyContent,
			String boardReplyLogIp, Integer boardReplyLevel, Integer boardReplyRef, Integer boardReplyStep,
			String memId) {
		super();
		this.boardReplyId = boardReplyId;
		this.boardId = boardId;
		this.boardReplyContent = boardReplyContent;
		this.boardReplyLogIp = boardReplyLogIp;
		this.boardReplyLevel = boardReplyLevel;
		this.boardReplyRef = boardReplyRef;
		BoardReplyStep = boardReplyStep;
		this.memId = memId;
	}

	public Integer getBoardReplyId() {
		return boardReplyId;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public String getBoardReplyContent() {
		return boardReplyContent;
	}

	public String getBoardReplyLogIp() {
		return boardReplyLogIp;
	}

	public Integer getBoardReplyLevel() {
		return boardReplyLevel;
	}

	public Integer getBoardReplyRef() {
		return boardReplyRef;
	}

	public Integer getBoardReplyStep() {
		return BoardReplyStep;
	}

	public String getMemId() {
		return memId;
	}
	
}
