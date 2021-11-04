package com.leetor4.model.nfe;

public class IcmsSt {

	private CstIcms cst = new CstIcms();
	
	private String CstIcms;
	private String vBCSTRet;
	private String vICMSSTRet;
	private String vBCSTDest;
	private String vICMSSTDes;
	
	public IcmsSt() {
		
	}

	public IcmsSt(CstIcms cst, String cstIcms, String vBCSTRet, String vICMSSTRet,
			String vBCSTDest, String vICMSSTDes) {
		super();
		this.cst = cst;
		CstIcms = cstIcms;
		this.vBCSTRet = vBCSTRet;
		this.vICMSSTRet = vICMSSTRet;
		this.vBCSTDest = vBCSTDest;
		this.vICMSSTDes = vICMSSTDes;
	}

	public CstIcms getCst() {
		return cst;
	}

	public String getCstIcms() {
		return CstIcms;
	}

	public String getvBCSTRet() {
		return vBCSTRet;
	}

	public String getvICMSSTRet() {
		return vICMSSTRet;
	}

	public String getvBCSTDest() {
		return vBCSTDest;
	}

	public String getvICMSSTDes() {
		return vICMSSTDes;
	}
	
}
