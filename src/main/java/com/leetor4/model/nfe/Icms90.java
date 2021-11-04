package com.leetor4.model.nfe;

public class Icms90 {

	private CstIcms cst = new CstIcms();
	
	private String modBC;
	private String vBC;
	private String aliqRedBC;
	private String aliqICMS;
	private String vICMS;
	private String modBCST;
	private String aliqMVAST;
	private String aliqRedBCST;
	private String vBCST;
	private String aliqICMSST;
	private String vICMSST;

	public Icms90() {
		
	}

	public Icms90(CstIcms cst, String modBC, String vBC, String aliqRedBC, String aliqICMS, String vICMS,
			String modBCST, String aliqMVAST, String aliqRedBCST, String vBCST, String aliqICMSST, String vICMSST) {
		super();
		this.cst = cst;
		this.modBC = modBC;
		this.vBC = vBC;
		this.aliqRedBC = aliqRedBC;
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

	public String getModBC() {
		return modBC;
	}

	public String getvBC() {
		return vBC;
	}

	public String getAliqRedBC() {
		return aliqRedBC;
	}

	public String getAliqICMS() {
		return aliqICMS;
	}

	public String getvICMS() {
		return vICMS;
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
