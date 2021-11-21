package com.leetor4.model.nfe;

public class PisAliq {
	
	private CstPisCofins cst = new CstPisCofins();
	
	private String vBC;
	private String aliqPIS;
	private String vPIS;
	
	private String vlBc;
	private String aliqPis;
	private String vlPis;
	

	private String qBCProd;
	private String vAliqProd;

	private String reg = "pisAliq";
	
	public PisAliq() {
		
	}


	public PisAliq(CstPisCofins cst, String vBC, String aliqPIS, String vPIS) {
		super();
		this.cst = cst;
		this.vBC = vBC;
		this.aliqPIS = aliqPIS;
		this.vPIS = vPIS;
	}


	public CstPisCofins getCst() {
		return cst;
	}


	public void setCst(CstPisCofins cst) {
		this.cst = cst;
	}


	public String getvBC() {
		return vBC;
	}


	public void setvBC(String vBC) {
		this.vBC = vBC;
	}


	public String getAliqPIS() {
		return aliqPIS;
	}


	public void setAliqPIS(String aliqPIS) {
		this.aliqPIS = aliqPIS;
	}


	public String getvPIS() {
		return vPIS;
	}


	public void setvPIS(String vPIS) {
		this.vPIS = vPIS;
	}


	public String getVlBc() {
		return vlBc;
	}


	public void setVlBc(String vlBc) {
		this.vlBc = vlBc;
	}


	public String getAliqPis() {
		return aliqPis;
	}


	public void setAliqPis(String aliqPis) {
		this.aliqPis = aliqPis;
	}


	public String getVlPis() {
		return vlPis;
	}


	public void setVlPis(String vlPis) {
		this.vlPis = vlPis;
	}


	public String getqBCProd() {
		return qBCProd;
	}


	public void setqBCProd(String qBCProd) {
		this.qBCProd = qBCProd;
	}


	public String getvAliqProd() {
		return vAliqProd;
	}


	public void setvAliqProd(String vAliqProd) {
		this.vAliqProd = vAliqProd;
	}


	public String getReg() {
		return reg;
	}
}
