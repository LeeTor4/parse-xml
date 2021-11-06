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
 
    public String addOrig(ImpostoNFE imps) {
    	return imps.getIcms().getCstA();
    }
	
}
