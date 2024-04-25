package kh.project.board.noticeboard.model.dto;

public class NoticeBoardListDto {
//	NOTICE_ID      NOT NULL NUMBER         
//	NOTICE_TITLE   NOT NULL VARCHAR2(120)  
//	NOTICE_CONTENT NOT NULL VARCHAR2(4000) 
//	NOTICE_TIME    NOT NULL TIMESTAMP(6)   
//	ADM_ID         NOT NULL VARCHAR2(20)
	private Integer noticeId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeTime; //TIMESTAMP
	private String admId;
	
	@Override
	public String toString() {
		return "NoticeBoardListDto [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + ", noticeTime=" + noticeTime + ", admId=" + admId + "]";
	}

	public NoticeBoardListDto() {
		super();
	}

	public NoticeBoardListDto(Integer noticeId, String noticeTitle, String noticeContent, String noticeTime,
			String admId) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeTime = noticeTime;
		this.admId = admId;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public String getAdmId() {
		return admId;
	}
	
}
