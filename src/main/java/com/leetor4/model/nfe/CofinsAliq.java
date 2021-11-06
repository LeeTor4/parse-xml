package com.leetor4.model.nfe;

public class CofinsAliq {
	
	private CstPisCofins cst = new CstPisCofins();
	
	private String vBC;
	private String aliqPIS;
	private String vPIS;
	
	
	public CofinsAliq() {
		
	}


	public CofinsAliq(CstPisCofins cst, String vBC, String aliqPIS, String vPIS) {
		super();
		this.cst = cst;
		this.vBC = vBC;
		this.aliqPIS = aliqPIS;
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


	public String getvPIS() {
		return vPIS;
	}
	
	
	

}
