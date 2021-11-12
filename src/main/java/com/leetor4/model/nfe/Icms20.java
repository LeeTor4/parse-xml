package com.leetor4.model.nfe;

public class Icms20 {

	private CstIcms cst = new CstIcms();
	
	private String modBC;
	private String aliqRedBC;
	private String vBC;
	private String aliqICMS;
	private String vICMS;
	
	private String reg = "icms20";
	
	public Icms20() {
		
	}

	public Icms20(CstIcms cst, String modBC, String aliqRedBC, String vBC, String aliqICMS, String vICMS) {
		super();
		this.cst = cst;
		this.modBC = modBC;
		this.aliqRedBC = aliqRedBC;
		this.vBC = vBC;
		this.aliqICMS = aliqICMS;
		this.vICMS = vICMS;
	}

	public CstIcms getCst() {
		return cst;
	}

	public String getModBC() {
		return modBC;
	}

	public String getAliqRedBC() {
		return aliqRedBC;
	}

	public String getvBC() {
		return vBC;
	}

	public String getAliqICMS() {
		return aliqICMS;
	}

	public String getvICMS() {
		return vICMS;
	}

	public String getReg() {
		return reg;
	}

	public void setCst(CstIcms cst) {
		this.cst = cst;
	}

	public void setModBC(String modBC) {
		this.modBC = modBC;
	}

	public void setAliqRedBC(String aliqRedBC) {
		this.aliqRedBC = aliqRedBC;
	}

	public void setvBC(String vBC) {
		this.vBC = vBC;
	}

	public void setAliqICMS(String aliqICMS) {
		this.aliqICMS = aliqICMS;
	}

	public void setvICMS(String vICMS) {
		this.vICMS = vICMS;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}
	
	
	
}
