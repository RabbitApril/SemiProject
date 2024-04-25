package kh.project.board.reviewboard.model.dto;

public class ReviewBoardReplyWriteDto {
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
	private String boardReplyLogIp;
	private String memId;
	
	@Override
	public String toString() {
		return "ReviewBoardReplyWriteDto [boardReplyId=" + boardReplyId + ", reviewId=" + reviewId
				+ ", boardReplyContent=" + boardReplyContent + ", boardReplyLogIp=" + boardReplyLogIp + ", memId="
				+ memId + "]";
	}

	public ReviewBoardReplyWriteDto(Integer boardReplyId, Integer reviewId, String boardReplyContent,
			String boardReplyLogIp, String memId) {
		super();
		this.boardReplyId = boardReplyId;
		this.reviewId = reviewId;
		this.boardReplyContent = boardReplyContent;
		this.boardReplyLogIp = boardReplyLogIp;
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

	public String getBoardReplyLogIp() {
		return boardReplyLogIp;
	}

	public String getMemId() {
		return memId;
	}
	
}
