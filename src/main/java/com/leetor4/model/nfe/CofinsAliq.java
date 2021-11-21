package com.leetor4.model.nfe;

public class CofinsAliq {
	
	private CstPisCofins cst = new CstPisCofins();
	
	private String vBC;
	private String aliqCofins;
	private String vCofins;
	

	private String qBCProd;
	private String vAliqProd;

	private String reg = "cofinsAliq";
	
	public CofinsAliq() {
		
	}


	public CofinsAliq(CstPisCofins cst, String vBC, String aliqCofins, String vCofins) {
		super();
		this.cst = cst;
		this.vBC = vBC;
		this.aliqCofins = aliqCofins;
		this.vCofins = vCofins;
	}


	public CstPisCofins getCst() {
		return cst;
	}


	public String getvBC() {
		return vBC;
	}


	public String getAliqCofins() {
		return aliqCofins;
	}


	public void setAliqCofins(String aliqCofins) {
		this.aliqCofins = aliqCofins;
	}


	public String getvCofins() {
		return vCofins;
	}


	public void setvCofins(String vCofins) {
		this.vCofins = vCofins;
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


	public void setCst(CstPisCofins cst) {
		this.cst = cst;
	}


	public void setvBC(String vBC) {
		this.vBC = vBC;
	}


	public String getReg() {
		return reg;
	}

    
	
}
