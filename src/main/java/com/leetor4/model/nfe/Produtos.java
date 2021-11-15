package com.leetor4.model.nfe;

public class Produtos {
 
	 private String numItem;
	 private String codItem;
	 private String ean;
	 private String descricao;
	 private String ncm;
	 private String cest;
	 private String cfop;
	 private String orig;
	 private String cst;
	
	 private String modBc;
	 private String aliqRedBc;
	 private String vlBc;
	 private String aliqIcms;
	 private String vlIcms;
	 private String motDeso;
	 private String modBcST;
	 private String aliqMVAST;
	 private String aliqRedBCST;
	 private String vlBcST;
	 private String vlBcSTRet;
	 private String aliqIcmsST;
	 private String vlIcmsST;
	 private String vlIcmsDeson;
	 private String motDesICMS;
	 private String vlIcmsSTRet;
	 private String cstPis;
	 private String cstCofins;
	 private String undComercial;
	 private String qtdComercial;
	 private String vlUnComerial;
	 private String vlProduto;
	 private String codEanTrib;
	 private String undTrib;
	 private String qtdTrib;
	 private String vlUnTrib;
	 private String indTot;
	 
	 
	 private Rastreamento rastro = new Rastreamento();
	

	 private ImpostoNFE imps = new ImpostoNFE();
	 
     
	 public String getNumItem() {
		return numItem;
	 }

	 public void setNumItem(String numItem) {
		this.numItem = numItem;
	 }

	 public String getCodItem() {
		return codItem;
	 }

	 public void setCodItem(String codItem) {
		this.codItem = codItem;
	 }

	 public String getEan() {
		return ean;
	 }

	 public void setEan(String ean) {
		this.ean = ean;
	 }

	 public String getDescricao() {
		return descricao;
	 }

	 public void setDescricao(String descricao) {
		this.descricao = descricao;
	 }

	 public String getNcm() {
		return ncm;
	 }

	 public void setNcm(String ncm) {
		this.ncm = ncm;
	 }

	 public String getCest() {
		return cest;
	 }

	 public void setCest(String cest) {
		this.cest = cest;
	 }

	 public String getCfop() {
		return cfop;
	 }

	 public void setCfop(String cfop) {
		this.cfop = cfop;
	 }

	 
	 public String getOrig() {
		return orig;
	}

	public void setOrig(String orig) {
		this.orig = orig;
	}

	public String getCst() {
		return cst;
	}

	public void setCst(String cst) {
		this.cst = cst;
	}
    
	public String getModBc() {
		return modBc;
	}

	public void setModBc(String modBc) {
		this.modBc = modBc;
	}
    
	public String getVlBc() {
		return vlBc;
	}

	public void setVlBc(String vlBc) {
		this.vlBc = vlBc;
	}

	public String getAliqIcms() {
		return aliqIcms;
	}

	public void setAliqIcms(String aliqIcms) {
		this.aliqIcms = aliqIcms;
	}

	public String getVlIcms() {
		return vlIcms;
	}

	public void setVlIcms(String vlIcms) {
		this.vlIcms = vlIcms;
	}
    
	public String getModBcST() {
		return modBcST;
	}

	public void setModBcST(String modBcST) {
		this.modBcST = modBcST;
	}

	public String getVlBcST() {
		return vlBcST;
	}

	public void setVlBcST(String vlBcST) {
		this.vlBcST = vlBcST;
	}

	public String getAliqIcmsST() {
		return aliqIcmsST;
	}

	public void setAliqIcmsST(String aliqIcmsST) {
		this.aliqIcmsST = aliqIcmsST;
	}

	public String getVlIcmsST() {
		return vlIcmsST;
	}

	public void setVlIcmsST(String vlIcmsST) {
		this.vlIcmsST = vlIcmsST;
	}

	public String getCstPis() {
		return cstPis;
	}

	public void setCstPis(String cstPis) {
		this.cstPis = cstPis;
	}
    
	public String getCstCofins() {
		return cstCofins;
	}

	public void setCstCofins(String cstCofins) {
		this.cstCofins = cstCofins;
	}

	public String getUndComercial() {
		return undComercial;
	 }

	 public void setUndComercial(String undComercial) {
		this.undComercial = undComercial;
	 }

	 public String getQtdComercial() {
		return qtdComercial;
	 }

	 public void setQtdComercial(String qtdComercial) {
		this.qtdComercial = qtdComercial;
	 }

	 public String getVlUnComerial() {
		return vlUnComerial;
	 }

	 public void setVlUnComerial(String vlUnComerial) {
		this.vlUnComerial = vlUnComerial;
	 }

	 public String getVlProduto() {
		return vlProduto;
	 }

	 public void setVlProduto(String vlProduto) {
		this.vlProduto = vlProduto;
	 }

	 public String getCodEanTrib() {
		return codEanTrib;
	 }

	 public void setCodEanTrib(String codEanTrib) {
		this.codEanTrib = codEanTrib;
	 }

	public String getUndTrib() {
		return undTrib;
	}

	public void setUndTrib(String undTrib) {
		this.undTrib = undTrib;
	}

	public String getQtdTrib() {
		return qtdTrib;
	}

	public void setQtdTrib(String qtdTrib) {
		this.qtdTrib = qtdTrib;
	}

	public String getVlUnTrib() {
		return vlUnTrib;
	}

	public void setVlUnTrib(String vlUnTrib) {
		this.vlUnTrib = vlUnTrib;
	}

	public String getIndTot() {
		return indTot;
	}

	public void setIndTot(String indTot) {
		this.indTot = indTot;
	}

	public Rastreamento getRastro() {
		return rastro;
	}

	public void setRastro(Rastreamento rastro) {
		this.rastro = rastro;
	}

	public ImpostoNFE getImps() {
		return imps;
	}

	public void setImps(ImpostoNFE imps) {
		this.imps = imps;
	}

	public String getVlBcSTRet() {
		return vlBcSTRet;
	}

	public void setVlBcSTRet(String vlBcSTRet) {
		this.vlBcSTRet = vlBcSTRet;
	}

	public String getVlIcmsSTRet() {
		return vlIcmsSTRet;
	}

	public void setVlIcmsSTRet(String vlIcmsSTRet) {
		this.vlIcmsSTRet = vlIcmsSTRet;
	}

	public String getMotDeso() {
		return motDeso;
	}

	public void setMotDeso(String motDeso) {
		this.motDeso = motDeso;
	}

	public String getAliqRedBc() {
		return aliqRedBc;
	}

	public void setAliqRedBc(String aliqRedBc) {
		this.aliqRedBc = aliqRedBc;
	}

	public String getAliqMVAST() {
		return aliqMVAST;
	}

	public void setAliqMVAST(String aliqMVAST) {
		this.aliqMVAST = aliqMVAST;
	}

	public String getAliqRedBCST() {
		return aliqRedBCST;
	}

	public void setAliqRedBCST(String aliqRedBCST) {
		this.aliqRedBCST = aliqRedBCST;
	}

	public String getVlIcmsDeson() {
		return vlIcmsDeson;
	}

	public void setVlIcmsDeson(String vlIcmsDeson) {
		this.vlIcmsDeson = vlIcmsDeson;
	}

	public String getMotDesICMS() {
		return motDesICMS;
	}

	public void setMotDesICMS(String motDesICMS) {
		this.motDesICMS = motDesICMS;
	}
	
	
}
