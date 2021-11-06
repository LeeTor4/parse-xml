package com.leetor4.model.nfe;



public class Cofins {

	private Enum<GrupoCofins> grupoCofins;
	
	private CofinsAliq    cofinsAliq   = new CofinsAliq();
	private CofinsQtde    cofinsQtde   = new CofinsQtde();
	private CofinsNaoTrib   cofinsNT   = new CofinsNaoTrib();
	private CofinsOutr    cofinsOutr   = new CofinsOutr(); 
	private CofinsSt        cofinsST   = new CofinsSt();
	
	
	private String cst;
	
	
	public Cofins() {
		
	}


	public Cofins(String cst) {
		super();
		this.cst = cst;
	}


	public Enum<GrupoCofins> getGrupoCofins() {
		return grupoCofins;
	}


	public void setGrupoCofins(Enum<GrupoCofins> grupoCofins) {
		this.grupoCofins = grupoCofins;
	}


	public CofinsAliq getCofinsAliq() {
		return cofinsAliq;
	}


	public void setCofinsAliq(CofinsAliq cofinsAliq) {
		this.cofinsAliq = cofinsAliq;
	}


	public CofinsQtde getCofinsQtde() {
		return cofinsQtde;
	}


	public void setCofinsQtde(CofinsQtde cofinsQtde) {
		this.cofinsQtde = cofinsQtde;
	}


	public CofinsNaoTrib getCofinsNT() {
		return cofinsNT;
	}


	public void setCofinsNT(CofinsNaoTrib cofinsNT) {
		this.cofinsNT = cofinsNT;
	}


	public CofinsOutr getCofinsOutr() {
		return cofinsOutr;
	}


	public void setCofinsOutr(CofinsOutr cofinsOutr) {
		this.cofinsOutr = cofinsOutr;
	}


	public CofinsSt getCofinsST() {
		return cofinsST;
	}


	public void setCofinsST(CofinsSt cofinsST) {
		this.cofinsST = cofinsST;
	}


	public String getCst() {
		return cst;
	}


	public void setCst(String cst) {
		this.cst = cst;
	}

    
	
}
