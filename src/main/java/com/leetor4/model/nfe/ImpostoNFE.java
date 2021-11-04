package com.leetor4.model.nfe;

public class ImpostoNFE {

	private Icms   icms   = new Icms();
	private Pis    pis    = new Pis();
	private Cofins cofins = new Cofins();
	
	
	
	public Icms getIcms() {
		return icms;
	}
	public void setIcms(Icms icms) {
		this.icms = icms;
	}
	public Pis getPis() {
		return pis;
	}
	public void setPis(Pis pis) {
		this.pis = pis;
	}
	public Cofins getCofins() {
		return cofins;
	}
	public void setCofins(Cofins cofins) {
		this.cofins = cofins;
	}
	
	
	
}
