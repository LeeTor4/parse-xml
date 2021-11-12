package com.leetor4.model.nfe;

public class Icms40_41_50 {

	private CstIcms cst = new CstIcms();
	
	private String vICMS;
	private String motDesICMS;
	
	private String reg = "icms40";
	
	public Icms40_41_50() {
		
	}

	public Icms40_41_50(String reg) {
		this.reg = reg;
	}
	
	public Icms40_41_50(CstIcms cst, String vICMS, String motDesICMS) {
		super();
		this.cst = cst;
		this.vICMS = vICMS;
		this.motDesICMS = motDesICMS;
	}

	public CstIcms getCst() {
		return cst;
	}

	public void setCst(CstIcms cst) {
		this.cst = cst;
	}

	public String getvICMS() {
		return vICMS;
	}

	public void setvICMS(String vICMS) {
		this.vICMS = vICMS;
	}

	public String getMotDesICMS() {
		return motDesICMS;
	}

	public void setMotDesICMS(String motDesICMS) {
		this.motDesICMS = motDesICMS;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

    
	
	
}
