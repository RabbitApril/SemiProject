package kh.project.member.model.dto;

public class MemberDto {
//	MEM_ID    NOT NULL VARCHAR2(20)  
//	MEM_PWD   NOT NULL VARCHAR2(20)  
//	MEM_EMAIL NOT NULL VARCHAR2(100) 
//	MEM_NICK  NOT NULL VARCHAR2(24)  
//	MEM_GRADE NOT NULL CHAR(1) 
	private String memId;
	private String memPwd;
	private String memEmail;
	private String memNick;
	private char memGrade;
	
	@Override
	public String toString() {
		return "MemberDto [memId=" + memId + ", memPwd=" + memPwd + ", memEmail=" + memEmail + ", memNick=" + memNick
				+ ", memGrade=" + memGrade + "]";
	}

	public MemberDto(String memId, String memPwd, String memEmail, String memNick, char memGrade) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memEmail = memEmail;
		this.memNick = memNick;
		this.memGrade = memGrade;
	}

	public String getMemId() {
		return memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public String getMemNick() {
		return memNick;
	}

	public char getMemGrade() {
		return memGrade;
	}
	
}
