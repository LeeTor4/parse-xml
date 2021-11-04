package com.leetor4.model.nfe;

public class Icms40_41_50 {

	private CstIcms cst = new CstIcms();
	
	private String vICMS;
	private String motDesICMS;
	
	public Icms40_41_50() {
		
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

	public String getvICMS() {
		return vICMS;
	}

	public String getMotDesICMS() {
		return motDesICMS;
	}
	
	
}
