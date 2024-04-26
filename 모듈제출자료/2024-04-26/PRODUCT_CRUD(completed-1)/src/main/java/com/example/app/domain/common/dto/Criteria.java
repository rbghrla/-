package com.example.app.domain.common.dto;

public class Criteria {

	private int pageno; // 현재 페이지
	private int amount; // 표시할 게시물 양(10건)
	private String type; // GD_CODE, GD_NAME, FMLY_PRICE, OGPL_NM
	private String keyword; // 포함문자열

	// Constructor(Default,Some arguments,All arguments)
	public Criteria() {
		pageno = 1;
		amount = 10;
	}

	public Criteria(int no, int amt) {
		pageno = no;
		amount = amt;
	}

	public Criteria(int pageno, int amount, String type, String keyword) {
		this.pageno = pageno;
		this.amount = amount;
		this.type = type;
		this.keyword = keyword;
	}

	// Getter and Setter
	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
