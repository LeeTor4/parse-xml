package com.leetor4.model.nfe;

public class IcmsCSOSN101 {

	 private CstIcms cst = new CstIcms();
	 private String aliqpCredSN; 
	 private String vCredICMSSN;
	 
	 public IcmsCSOSN101() {
		
	}

	public IcmsCSOSN101(CstIcms cst, String aliqpCredSN, String vCredICMSSN) {
		super();
		this.cst = cst;
		this.aliqpCredSN = aliqpCredSN;
		this.vCredICMSSN = vCredICMSSN;
	}

	public CstIcms getCst() {
		return cst;
	}

	public void setCst(CstIcms cst) {
		this.cst = cst;
	}

	public String getAliqpCredSN() {
		return aliqpCredSN;
	}

	public void setAliqpCredSN(String aliqpCredSN) {
		this.aliqpCredSN = aliqpCredSN;
	}

	public String getvCredICMSSN() {
		return vCredICMSSN;
	}

	public void setvCredICMSSN(String vCredICMSSN) {
		this.vCredICMSSN = vCredICMSSN;
	}
	 
	 
}
