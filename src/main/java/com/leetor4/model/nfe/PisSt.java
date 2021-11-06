package com.leetor4.model.nfe;

public class PisSt {

	private CstPisCofins cst = new CstPisCofins();
	
	private String vBC;
	private String aliqPIS;
	private String qBCProd; 
	private String vAliqProd;
	private String vPIS;
	
	public PisSt() {
		
	}

	public PisSt(CstPisCofins cst, String vBC, String aliqPIS, String qBCProd, String vAliqProd, String vPIS) {
		super();
		this.cst = cst;
		this.vBC = vBC;
		this.aliqPIS = aliqPIS;
		this.qBCProd = qBCProd;
		this.vAliqProd = vAliqProd;
		this.vPIS = vPIS;
	}

	public CstPisCofins getCst() {
		return cst;
	}

	public String getvBC() {
		return vBC;
	}

	public String getAliqPIS() {
		return aliqPIS;
	}

	public String getqBCProd() {
		return qBCProd;
	}

	public String getvAliqProd() {
		return vAliqProd;
	}

	public String getvPIS() {
		return vPIS;
	}
	
	
	
}
