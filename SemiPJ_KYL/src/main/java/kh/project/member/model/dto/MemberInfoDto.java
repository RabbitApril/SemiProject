package kh.project.member.model.dto;

public class MemberInfoDto {
	private String memId;
	private String memEmail;
	private String memNick;
	private Integer memGrade;
	
	@Override
	public String toString() {
		return "MemberInfoDto [memId=" + memId + ", memEmail=" + memEmail + ", memNick=" + memNick + ", memGrade="
				+ memGrade + "]";
	}
	
	public MemberInfoDto() {
		super();
	}

	public MemberInfoDto(String memId, String memEmail, String memNick, Integer memGrade) {
		super();
		this.memId = memId;
		this.memEmail = memEmail;
		this.memNick = memNick;
		this.memGrade = memGrade;
	}
	
	public String getMemId() {
		return memId;
	}
	
	public String getMemEmail() {
		return memEmail;
	}
	
	public String getMemNick() {
		return memNick;
	}
	
	public Integer getMemGrade() {
		return memGrade;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}

	public void setMemGrade(Integer memGrade) {
		this.memGrade = memGrade;
	}
	
}
