package MemberCRUD.Domain.Dto;

public class NotifyDto {
	private String id;
	private int notifyCode;
	private String notifyDate;

	public NotifyDto() {
	}

	public NotifyDto(String id, int notifyCode) {
		this.id = id;
		this.notifyCode = notifyCode;
	}

	public NotifyDto(String id, int notifyCode, String notifyDate) {
		super();
		this.id = id;
		this.notifyCode = notifyCode;
		this.notifyDate = notifyDate;
	}

	@Override
	public String toString() {
		return "NotifyServiceImpl [id=" + id + ", notifyCode=" + notifyCode + ", notifyDate=" + notifyDate + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNotifyCode() {
		return notifyCode;
	}

	public void setNotifyCode(int notifyCode) {
		this.notifyCode = notifyCode;
	}

	public String getNotifyDate() {
		return notifyDate;
	}

	public void setNotifyDate(String notifyDate) {
		this.notifyDate = notifyDate;
	}

}
