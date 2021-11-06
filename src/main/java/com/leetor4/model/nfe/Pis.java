package com.leetor4.model.nfe;



public class Pis {

	private Enum<GrupoPis> grupoPis;

	private PisAliq pisAliq      = new PisAliq();
	private PisQtde pisQtde      = new PisQtde();
	private PisNaoTrib   pisNT   = new PisNaoTrib();
	private PisOutr    pisOutr   = new PisOutr(); 
	private PisSt        pisST   = new PisSt();
	
	private String cst;
	
	public Pis() {
		
	}
	
	
	
	public Pis(String cst) {
		super();
		this.cst = cst;

	}

	public Enum<GrupoPis> getGrupoPis() {
		return grupoPis;
	}

	public void setGrupoPis(Enum<GrupoPis> grupoPis) {
		this.grupoPis = grupoPis;
	}

	public String getCst() {
		return cst;
	}

	public void setCst(String cst) {
		this.cst = cst;
	}



	public PisAliq getPisAliq() {
		return pisAliq;
	}



	public void setPisAliq(PisAliq pisAliq) {
		this.pisAliq = pisAliq;
	}



	public PisQtde getPisQtde() {
		return pisQtde;
	}



	public void setPisQtde(PisQtde pisQtde) {
		this.pisQtde = pisQtde;
	}



	public PisNaoTrib getPisNT() {
		return pisNT;
	}



	public void setPisNT(PisNaoTrib pisNT) {
		this.pisNT = pisNT;
	}



	public PisOutr getPisOutr() {
		return pisOutr;
	}



	public void setPisOutr(PisOutr pisOutr) {
		this.pisOutr = pisOutr;
	}



	public PisSt getPisST() {
		return pisST;
	}



	public void setPisST(PisSt pisST) {
		this.pisST = pisST;
	}

    

	
	
}
