package com.leetor4.model.nfe;

public class CofinsQtde {
	
	private CstPisCofins cst = new CstPisCofins();
	
	private String qBCProd;
	private String vAliqProd; 
	private String vPIS;
	
	public CofinsQtde() {
		
	}

	public CofinsQtde(CstPisCofins cst, String qBCProd, String vAliqProd, String vPIS) {
		super();
		this.cst = cst;
		this.qBCProd = qBCProd;
		this.vAliqProd = vAliqProd;
		this.vPIS = vPIS;
	}

	public CstPisCofins getCst() {
		return cst;
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
