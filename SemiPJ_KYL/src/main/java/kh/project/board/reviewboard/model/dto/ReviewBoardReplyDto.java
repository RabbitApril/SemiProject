package kh.project.board.reviewboard.model.dto;

public class ReviewBoardReplyDto {
//	BOARD_REPLY_ID         NOT NULL NUMBER         
//	REVIEW_ID              NOT NULL NUMBER         
//	BOARD_REPLY_CONTENT    NOT NULL VARCHAR2(4000) 
//	BOARD_REPLY_WRITE_TIME NOT NULL TIMESTAMP(6)   
//	BOARD_REPLY_LOG_IP              VARCHAR2(15)   
//	BOARD_REPLY_LEVEL      NOT NULL NUMBER(2)      
//	MEM_ID                 NOT NULL VARCHAR2(20)   
	private Integer boardReplyId;
	private Integer reviewId;
	private String boardReplyContent;
	private String boardReplyWriteTime;
	private String boardReplyLogIp;
	private Integer boardReplyLevel;
	private String memId;
	
	@Override
	public String toString() {
		return "ReviewBoardReplyDto [boardReplyId=" + boardReplyId + ", reviewId=" + reviewId + ", boardReplyContent="
				+ boardReplyContent + ", boardReplyWriteTime=" + boardReplyWriteTime + ", boardReplyLogIp="
				+ boardReplyLogIp + ", boardReplyLevel=" + boardReplyLevel + ", memId=" + memId + "]";
	}
	public ReviewBoardReplyDto() {
		super();
	}
	public ReviewBoardReplyDto(Integer boardReplyId, Integer reviewId, String boardReplyContent,
			String boardReplyWriteTime, String boardReplyLogIp, Integer boardReplyLevel, String memId) {
		super();
		this.boardReplyId = boardReplyId;
		this.reviewId = reviewId;
		this.boardReplyContent = boardReplyContent;
		this.boardReplyWriteTime = boardReplyWriteTime;
		this.boardReplyLogIp = boardReplyLogIp;
		this.boardReplyLevel = boardReplyLevel;
		this.memId = memId;
	}
	
	public Integer getBoardReplyId() {
		return boardReplyId;
	}
	
	public Integer getReviewId() {
		return reviewId;
	}
	
	public String getBoardReplyContent() {
		return boardReplyContent;
	}
	
	public String getBoardReplyWriteTime() {
		return boardReplyWriteTime;
	}
	
	public String getBoardReplyLogIp() {
		return boardReplyLogIp;
	}
	
	public Integer getBoardReplyLevel() {
		return boardReplyLevel;
	}
	
	public String getMemId() {
		return memId;
	}
	
	public void setBoardReplyId(Integer boardReplyId) {
		this.boardReplyId = boardReplyId;
	}
	
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	
	public void setBoardReplyContent(String boardReplyContent) {
		this.boardReplyContent = boardReplyContent;
	}
	
	public void setBoardReplyWriteTime(String boardReplyWriteTime) {
		this.boardReplyWriteTime = boardReplyWriteTime;
	}
	
	public void setBoardReplyLogIp(String boardReplyLogIp) {
		this.boardReplyLogIp = boardReplyLogIp;
	}
	
	public void setBoardReplyLevel(Integer boardReplyLevel) {
		this.boardReplyLevel = boardReplyLevel;
	}
	
	public void setMemId(String memId) {
		this.memId = memId;
	}

}
