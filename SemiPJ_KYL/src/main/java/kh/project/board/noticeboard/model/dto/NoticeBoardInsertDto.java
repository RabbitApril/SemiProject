package kh.project.board.noticeboard.model.dto;

import java.util.List;

public class NoticeBoardInsertDto {
//	NOTICE_ID      NOT NULL NUMBER         
//	NOTICE_TITLE   NOT NULL VARCHAR2(120)  
//	NOTICE_CONTENT NOT NULL VARCHAR2(4000) 
//	NOTICE_TIME    NOT NULL TIMESTAMP(6)   
//	ADM_ID         NOT NULL VARCHAR2(20)
	private String noticeTitle;
	private String noticeContent;
	private String admId;
	private List<NoticeBoardFileWriteDto> fileList;
	
	@Override
	public String toString() {
		return "NoticeBoardInsertDto [noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", admId="
				+ admId + ", fileList=" + fileList + "]";
	}

	public NoticeBoardInsertDto(String noticeTitle, String noticeContent, String admId,
			List<NoticeBoardFileWriteDto> fileList) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.admId = admId;
		this.fileList = fileList;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public String getAdmId() {
		return admId;
	}

	public List<NoticeBoardFileWriteDto> getFileList() {
		return fileList;
	}
	
}
