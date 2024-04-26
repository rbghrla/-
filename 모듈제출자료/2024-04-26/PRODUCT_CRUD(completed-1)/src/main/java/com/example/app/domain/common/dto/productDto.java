package com.example.app.domain.common.dto;

public class productDto {
	
	private int GD_CODE;
	private String GD_NM;
	private int FMLY_PRCE;
	private String SPLY_CO_NM;
	private String OGPL_NM;
	
	// Constructor(Default,Some arguments,All arguments)
	public productDto() {}
	public productDto(int GD_CODE) {
		this.GD_CODE = GD_CODE;
	}
	public productDto(int GD_CODE, String GD_NM, int FMLY_PRCE, String SPLY_CO_NM, String OGPL_NM) {
		this.GD_CODE = GD_CODE;
		this.GD_NM = GD_NM;
		this.FMLY_PRCE = FMLY_PRCE;
		this.SPLY_CO_NM = SPLY_CO_NM;
		this.OGPL_NM = OGPL_NM;
	}
	
	// toString
	@Override
	public String toString() {
		return "productDto [GD_CODE=" + GD_CODE + ", GD_NM=" + GD_NM + ", FMLY_PRCE=" + FMLY_PRCE + ", SPLY_CO_NM="
				+ SPLY_CO_NM + ", OGPL_NM=" + OGPL_NM + "]";
	}
	
	// Getter and Setter
	public int getGD_CODE() {
		return GD_CODE;
	}

	public void setGD_CODE(int gD_CODE) {
		this.GD_CODE = gD_CODE;
	}

	public String getGD_NM() {
		return GD_NM;
	}

	public void setGD_NM(String gD_NM) {
		this.GD_NM = gD_NM;
	}

	public int getFMLY_PRCE() {
		return FMLY_PRCE;
	}

	public void setFMLY_PRCE(int fMLY_PRCE) {
		this.FMLY_PRCE = fMLY_PRCE;
	}

	public String getSPLY_CO_NM() {
		return SPLY_CO_NM;
	}

	public void setSPLY_CO_NM(String sPLY_CO_NM) {
		this.SPLY_CO_NM = sPLY_CO_NM;
	}

	public String getOGPL_NM() {
		return OGPL_NM;
	}

	public void setOGPL_NM(String oGPL_NM) {
		this.OGPL_NM = oGPL_NM;
	}
	
}
