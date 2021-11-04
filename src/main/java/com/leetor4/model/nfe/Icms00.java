package com.leetor4.model.nfe;

public class Icms00 {

	private CstIcms cst = new CstIcms();
	private String modBC;
	private String vBC;
	private String aliqImp;
	private String vICMS;
	
	public Icms00() {
		
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

	public String getModBC() {
		return modBC;
	}

	public String getvBC() {
		return vBC;
	}

	public String getAliqImp() {
		return aliqImp;
	}

	public String getvICMS() {
		return vICMS;
	}
	
	
	
}
