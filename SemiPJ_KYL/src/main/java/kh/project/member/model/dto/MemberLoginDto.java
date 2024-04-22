package kh.project.member.model.dto;

public class MemberLoginDto {
//	MEM_ID    NOT NULL VARCHAR2(20)  
//	MEM_PWD   NOT NULL VARCHAR2(20)
//	MEM_GRADE NOT NULL CHAR(1) 
	private String memId;
	private String memPwd;
	
	@Override
	public String toString() {
		return "MemberLoginDto [memId=" + memId + ", memPwd=" + memPwd + "]";
	}
	
	public MemberLoginDto() {
		super();
	}
	
	public MemberLoginDto(String memId, String memPwd) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
	}
	
	public String getMemId() {
		return memId;
	}
	
	public String getMemPwd() {
		return memPwd;
	}

}
