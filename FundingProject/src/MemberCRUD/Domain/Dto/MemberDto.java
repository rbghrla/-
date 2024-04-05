package MemberCRUD.Domain.Dto;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String addr;
	private int tel;
	private String authority;
	
	public MemberDto() {}
	public MemberDto(String id, String pw, String name, String addr, int tel, String authority) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", addr=" + addr + ", tel=" + tel
				+ ", authority=" + authority + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}	
	
	
}
