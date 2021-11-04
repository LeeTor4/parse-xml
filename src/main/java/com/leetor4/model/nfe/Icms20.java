package com.leetor4.model.nfe;

public class Icms20 {

	private CstIcms cst = new CstIcms();
	
	private String modBC;
	private String aliqRedBC;
	private String vBC;
	private String aliqICMS;
	private String vICMS;
	
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
	
	
	
}
