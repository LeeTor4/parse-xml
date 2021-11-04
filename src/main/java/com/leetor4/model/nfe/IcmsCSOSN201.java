package com.leetor4.model.nfe;

public class IcmsCSOSN201 {

	 private CstIcms cst = new CstIcms();
	 
	 private String modBCST;
	 private String aliqMVAST;
	 private String aliqRedBCST;
	 private String vBCST;
	 private String aliqICMSST;
	 private String vICMSST;
	 private String aliqCredSN;
	 private String vCredICMSSN;
	 
	 public IcmsCSOSN201() {
		
	}

	public IcmsCSOSN201(CstIcms cst, String modBCST, String aliqMVAST, String aliqRedBCST, String vBCST,
			String aliqICMSST, String vICMSST, String aliqCredSN, String vCredICMSSN) {
		super();
		this.cst = cst;
		this.modBCST = modBCST;
		this.aliqMVAST = aliqMVAST;
		this.aliqRedBCST = aliqRedBCST;
		this.vBCST = vBCST;
		this.aliqICMSST = aliqICMSST;
		this.vICMSST = vICMSST;
		this.aliqCredSN = aliqCredSN;
		this.vCredICMSSN = vCredICMSSN;
	}

	public CstIcms getCst() {
		return cst;
	}

	public void setCst(CstIcms cst) {
		this.cst = cst;
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

	public String getAliqCredSN() {
		return aliqCredSN;
	}

	public void setAliqCredSN(String aliqCredSN) {
		this.aliqCredSN = aliqCredSN;
	}

	public String getvCredICMSSN() {
		return vCredICMSSN;
	}

	public void setvCredICMSSN(String vCredICMSSN) {
		this.vCredICMSSN = vCredICMSSN;
	}
	 
	 
}
