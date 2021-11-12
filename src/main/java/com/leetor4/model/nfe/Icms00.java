package com.leetor4.model.nfe;

public class Icms00 {

	private CstIcms cst = new CstIcms();
	private String modBC;
	private String vBC;
	private String aliqImp;
	private String vICMS;
	private String reg = "icms00";
	
	public Icms00() {
		
	}

	public Icms00(String reg ) {
		this.reg = reg;
	}
	
	public Icms00(CstIcms cst, String modBC, String vBC, String aliqImp, String vICMS) {
		super();
		this.cst = cst;
		this.modBC = modBC;
		this.vBC = vBC;
		this.aliqImp = aliqImp;
		this.vICMS = vICMS;
	}

	public CstIcms getCst() {
		return cst;
	}

	public void setCst(CstIcms cst) {
		this.cst = cst;
	}

	public String getModBC() {
		return modBC;
	}

	public void setModBC(String modBC) {
		this.modBC = modBC;
	}

	public String getvBC() {
		return vBC;
	}

	public void setvBC(String vBC) {
		this.vBC = vBC;
	}

	public String getAliqImp() {
		return aliqImp;
	}

	public void setAliqImp(String aliqImp) {
		this.aliqImp = aliqImp;
	}

	public String getvICMS() {
		return vICMS;
	}

	public void setvICMS(String vICMS) {
		this.vICMS = vICMS;
	}

	public String getReg() {
		return reg;
	}

    
	
	
	
}
