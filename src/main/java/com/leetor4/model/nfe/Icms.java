package com.leetor4.model.nfe;

public class Icms {

	private Enum<GrupoIcms> grupoIcms;

	private Icms00 icms00 = new Icms00();
	private Icms10 icms10 = new Icms10();
	private Icms20 icms20 = new Icms20();
	private Icms30 icms30 = new Icms30();
	private Icms40_41_50 icms40_41_50 = new Icms40_41_50();
	private Icms51 icms51 = new Icms51();
	private Icms60 icms60 = new Icms60();
	private Icms70 icms70 = new Icms70();
	private Icms90 icms90 = new Icms90();
	private ICMSPartilha icmsPartilha = new ICMSPartilha();
	private IcmsSt icmsSt = new IcmsSt();
	private ICMSTotal icmsTotal = new ICMSTotal();

	private IcmsCSOSN101 icmsCSOSN101 = new IcmsCSOSN101();
	private IcmsCSOSN102_103_300_400 icmsCSOSN102_103_300_400 = new IcmsCSOSN102_103_300_400();
	private IcmsCSOSN201 icmsCSOSN201 = new IcmsCSOSN201();
	private IcmsCSOSN202_203 icmsCSOSN102_203 = new IcmsCSOSN202_203();
	private IcmsCSOSN500 icmsCSOSN500 = new IcmsCSOSN500();
	private IcmsCSOSN900 icmsCSOSN900 = new IcmsCSOSN900();
	
    private String cstA;
    private String cstB;
    private String CSOSN;
    
	public Icms() {

	}

    
	public Icms(String cstA, String cstB) {
		super();
		this.cstA = cstA;
		this.cstB = cstB;
	}

	
	public Enum<GrupoIcms> getGrupoIcms() {
		return grupoIcms;
	}

	public void setGrupoIcms(Enum<GrupoIcms> grupoIcms) {
		this.grupoIcms = grupoIcms;
	}

	public Icms60 getIcms60() {
		return icms60;
	}

	public void setIcms60(Icms60 icms60) {
		this.icms60 = icms60;
	}

	public Icms00 getIcms00() {
		return icms00;
	}

	public void setIcms00(Icms00 icms00) {
		this.icms00 = icms00;
	}

	public Icms10 getIcms10() {
		return icms10;
	}

	public void setIcms10(Icms10 icms10) {
		this.icms10 = icms10;
	}

	public Icms20 getIcms20() {
		return icms20;
	}

	public void setIcms20(Icms20 icms20) {
		this.icms20 = icms20;
	}

	public Icms30 getIcms30() {
		return icms30;
	}

	public void setIcms30(Icms30 icms30) {
		this.icms30 = icms30;
	}

	public Icms40_41_50 getIcms40_41_50() {
		return icms40_41_50;
	}

	public void setIcms40_41_50(Icms40_41_50 icms40_41_50) {
		this.icms40_41_50 = icms40_41_50;
	}

	public Icms51 getIcms51() {
		return icms51;
	}

	public void setIcms51(Icms51 icms51) {
		this.icms51 = icms51;
	}

	public Icms70 getIcms70() {
		return icms70;
	}

	public void setIcms70(Icms70 icms70) {
		this.icms70 = icms70;
	}

	public Icms90 getIcms90() {
		return icms90;
	}

	public void setIcms90(Icms90 icms90) {
		this.icms90 = icms90;
	}

	public ICMSPartilha getIcmsPartilha() {
		return icmsPartilha;
	}

	public void setIcmsPartilha(ICMSPartilha icmsPartilha) {
		this.icmsPartilha = icmsPartilha;
	}

	public ICMSTotal getIcmsTotal() {
		return icmsTotal;
	}

	public void setIcmsTotal(ICMSTotal icmsTotal) {
		this.icmsTotal = icmsTotal;
	}

	public IcmsSt getIcmsSt() {
		return icmsSt;
	}

	public void setIcmsSt(IcmsSt icmsSt) {
		this.icmsSt = icmsSt;
	}

	public IcmsCSOSN101 getIcmsCSOSN101() {
		return icmsCSOSN101;
	}

	public void setIcmsCSOSN101(IcmsCSOSN101 icmsCSOSN101) {
		this.icmsCSOSN101 = icmsCSOSN101;
	}

	public IcmsCSOSN102_103_300_400 getIcmsCSOSN102_103_300_400() {
		return icmsCSOSN102_103_300_400;
	}

	public void setIcmsCSOSN102_103_300_400(IcmsCSOSN102_103_300_400 icmsCSOSN102_103_300_400) {
		this.icmsCSOSN102_103_300_400 = icmsCSOSN102_103_300_400;
	}

	public IcmsCSOSN201 getIcmsCSOSN201() {
		return icmsCSOSN201;
	}

	public void setIcmsCSOSN201(IcmsCSOSN201 icmsCSOSN201) {
		this.icmsCSOSN201 = icmsCSOSN201;
	}

	public IcmsCSOSN202_203 getIcmsCSOSN102_203() {
		return icmsCSOSN102_203;
	}

	public void setIcmsCSOSN102_203(IcmsCSOSN202_203 icmsCSOSN102_203) {
		this.icmsCSOSN102_203 = icmsCSOSN102_203;
	}

	public IcmsCSOSN500 getIcmsCSOSN500() {
		return icmsCSOSN500;
	}

	public void setIcmsCSOSN500(IcmsCSOSN500 icmsCSOSN500) {
		this.icmsCSOSN500 = icmsCSOSN500;
	}

	public IcmsCSOSN900 getIcmsCSOSN900() {
		return icmsCSOSN900;
	}

	public void setIcmsCSOSN900(IcmsCSOSN900 icmsCSOSN900) {
		this.icmsCSOSN900 = icmsCSOSN900;
	}


	public String getCstA() {
		return cstA;
	}


	public String getCstB() {
		return cstB;
	}


	public String getCSOSN() {
		return CSOSN;
	}

	
	
}
