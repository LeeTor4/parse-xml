package com.leetor4.model.nfe;

public class Icms60 {

	private CstIcms cst = new CstIcms();
	private String vBCSTRet;
	private String vICMSSTRet;
	
	private String reg = "icms60";
	
	public Icms60() {
		
	}
	public Icms60(String reg) {
		this.reg = reg;
	}
	
	public Icms60(CstIcms cst, String vBCSTRet, String vICMSSTRet) {
		super();
		this.cst = cst;
		this.vBCSTRet = vBCSTRet;
		this.vICMSSTRet = vICMSSTRet;
		
	}
	public CstIcms getCst() {
		return cst;
	}
	public void setCst(CstIcms cst) {
		this.cst = cst;
	}
	public String getvBCSTRet() {
		return vBCSTRet;
	}
	public void setvBCSTRet(String vBCSTRet) {
		this.vBCSTRet = vBCSTRet;
	}
	public String getvICMSSTRet() {
		return vICMSSTRet;
	}
	public void setvICMSSTRet(String vICMSSTRet) {
		this.vICMSSTRet = vICMSSTRet;
	}
	public String getReg() {
		return reg;
	}
	
	
	

}
