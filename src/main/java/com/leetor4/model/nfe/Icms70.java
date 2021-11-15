package com.leetor4.model.nfe;

public class Icms70 {

	private CstIcms cst = new CstIcms();
	
	private String modBC;
	private String aliqRedBC;
	private String vBC;
	private String aliqICMS;
	private String vICMS;
	private String modBCST;
	private String aliqMVAST;
	private String aliqRedBCST;
	private String vBCST;
	private String aliqICMSST;
	private String vICMSST;
	private String vICMSDeson;
	private String motDesICMS;
	
	private String reg = "icms70";
	
	public Icms70() {
		
	}

	public Icms70(CstIcms cst, String modBC, String aliqRedBC, String vBC, String aliqICMS, String vICMS,
			String modBCST, String aliqMVAST, String aliqRedBCST, String vBCST, String aliqICMSST, String vICMSST) {
		super();
		this.cst = cst;
		this.modBC = modBC;
		this.aliqRedBC = aliqRedBC;
		this.vBC = vBC;
		this.aliqICMS = aliqICMS;
		this.vICMS = vICMS;
		this.modBCST = modBCST;
		this.aliqMVAST = aliqMVAST;
		this.aliqRedBCST = aliqRedBCST;
		this.vBCST = vBCST;
		this.aliqICMSST = aliqICMSST;
		this.vICMSST = vICMSST;
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

	public String getAliqRedBC() {
		return aliqRedBC;
	}

	public void setAliqRedBC(String aliqRedBC) {
		this.aliqRedBC = aliqRedBC;
	}

	public String getvBC() {
		return vBC;
	}

	public void setvBC(String vBC) {
		this.vBC = vBC;
	}

	public String getAliqICMS() {
		return aliqICMS;
	}

	public void setAliqICMS(String aliqICMS) {
		this.aliqICMS = aliqICMS;
	}

	public String getvICMS() {
		return vICMS;
	}

	public void setvICMS(String vICMS) {
		this.vICMS = vICMS;
	}

	public String getModBCST() {
		return modBCST;
	}

	public void setModBCST(String modBCST) {
		this.modBCST = modBCST;
	}

	public String getAliqMVAST() {
		return aliqMVAST;
	}

	public void setAliqMVAST(String aliqMVAST) {
		this.aliqMVAST = aliqMVAST;
	}

	public String getAliqRedBCST() {
		return aliqRedBCST;
	}

	public void setAliqRedBCST(String aliqRedBCST) {
		this.aliqRedBCST = aliqRedBCST;
	}

	public String getvBCST() {
		return vBCST;
	}

	public void setvBCST(String vBCST) {
		this.vBCST = vBCST;
	}

	public String getAliqICMSST() {
		return aliqICMSST;
	}

	public void setAliqICMSST(String aliqICMSST) {
		this.aliqICMSST = aliqICMSST;
	}

	public String getvICMSST() {
		return vICMSST;
	}

	public void setvICMSST(String vICMSST) {
		this.vICMSST = vICMSST;
	}

	public String getvICMSDeson() {
		return vICMSDeson;
	}

	public void setvICMSDeson(String vICMSDeson) {
		this.vICMSDeson = vICMSDeson;
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
