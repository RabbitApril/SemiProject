package kh.project.board.noticeboard.model.dto;

import java.util.List;

public class NoticeBoardReadDto {
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
	private List<NoticeBoardFileReadDto> filedtolist;
	
	@Override
	public String toString() {
		return "NoticeBoardReadDto [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + ", noticeTime=" + noticeTime + ", admId=" + admId + ", filedtolist=" + filedtolist
				+ "]";
	}

	public NoticeBoardReadDto(Integer noticeId, String noticeTitle, String noticeContent, String noticeTime,
			String admId) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		noticeContent = noticeContent.replaceAll("\\r?\\n", "<br>");
		noticeContent = noticeContent.replaceAll(" ", "&nbsp;");
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

	public List<NoticeBoardFileReadDto> getFiledtolist() {
		return filedtolist;
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

	public void setFiledtolist(List<NoticeBoardFileReadDto> filedtolist) {
		this.filedtolist = filedtolist;
	}
	
}
