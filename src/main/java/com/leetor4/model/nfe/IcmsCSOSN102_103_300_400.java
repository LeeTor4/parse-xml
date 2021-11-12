package com.leetor4.model.nfe;

public class IcmsCSOSN102_103_300_400 {

	 private CstIcms cst = new CstIcms();
	 
	 private String reg1 = "icmssn101";
	 private String reg2 = "icmssn102";
	 private String reg3 = "icmssn103";
	 private String reg4 = "icmssn300";
	 private String reg5 = "icmssn400";
	 
	 public IcmsCSOSN102_103_300_400() {
		
	 }

	public IcmsCSOSN102_103_300_400(CstIcms cst) {
		super();
		this.cst = cst;
	}

	public CstIcms getCst() {
		return cst;
	}

	public void setCst(CstIcms cst) {
		this.cst = cst;
	}

	public String getReg1() {
		return reg1;
	}

	public String getReg2() {
		return reg2;
	}

	public String getReg3() {
		return reg3;
	}

	public String getReg4() {
		return reg4;
	}

	public String getReg5() {
		return reg5;
	}

	
	 
}
