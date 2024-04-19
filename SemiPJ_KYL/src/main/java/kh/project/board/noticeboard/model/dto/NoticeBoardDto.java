package kh.project.board.noticeboard.model.dto;

public class NoticeBoardDto {
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
		return "NoticeBoardDto [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + ", noticeTime=" + noticeTime + ", admId=" + admId + "]";
	}

	public NoticeBoardDto() {
		super();
	}

	public NoticeBoardDto(Integer noticeId, String noticeTitle, String noticeContent, String noticeTime, String admId) {
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

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	public void setAdmId(String admId) {
		this.admId = admId;
	}
	
}
