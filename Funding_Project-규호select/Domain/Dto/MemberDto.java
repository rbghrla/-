package Funding_Project.Domain.Dto;

public class MemberDto {
 private String id;
 private String pw;
 private String name;
 private String addr;
 private int tel;
 private int authority ;
 
 public MemberDto() {}
 public MemberDto(String id, String pw, String name, String addr, int tel ,int authority) {
	 this.id = id;
	 this.pw = pw;
	 this.name = name;
	 this.addr = addr;
	 this.tel = tel;
	 this.authority = authority;
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
public int getAuthority() {
	return authority;
}
public void setAuthority(int authority) {
	this.authority = authority;
}


@Override
public String toString() {
	return "BookDto [id=" + id + ", pw=" + pw + ", name=" + name + ", addr=" + addr + ", tel=" + tel + ", authority="
			+ authority + "]";
}
 
 
 

 
 





 
 
 
}
