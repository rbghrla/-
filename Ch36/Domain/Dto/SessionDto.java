package Ch36.Domain.Dto;

public class SessionDto {
	private int sessionId;
	private String username;
	private String role;
	// 생성자
	public SessionDto() {}
	public SessionDto(int sessionId, String username) {
		super();
		this.sessionId = sessionId;
		this.username = username;
		this.role = role;
	}
	// toString
	@Override
	public String toString() {
		return "SessionDto [sessionId=" + sessionId + ", username=" + username + ", role=" + role + "]";
	}
	
	// getter and setter
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
