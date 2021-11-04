package com.leetor4.model.nfe;

public class Icms30 {

	private CstIcms cst = new CstIcms();
	
	private String modBCST;
	private String aliqMVAST;
	private String aliqRedBCST;
	private String vBCST;
	private String aliqICMSST;
	private String vICMSST;
	
	public Icms30() {
		
	}

	
	public Icms30(CstIcms cst, String modBCST, String aliqMVAST, String aliqRedBCST, String vBCST, String aliqICMSST,
			String vICMSST) {
		super();
		this.cst = cst;
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

	public String getModBCST() {
		return modBCST;
	}

	public String getAliqMVAST() {
		return aliqMVAST;
	}

	public String getAliqRedBCST() {
		return aliqRedBCST;
	}

	public String getvBCST() {
		return vBCST;
	}

	public String getAliqICMSST() {
		return aliqICMSST;
	}

	public String getvICMSST() {
		return vICMSST;
	}
	
	
}
