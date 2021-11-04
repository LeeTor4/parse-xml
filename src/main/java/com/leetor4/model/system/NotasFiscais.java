package com.leetor4.model.system;


import java.io.Serializable;
import java.util.Objects;


public class NotasFiscais implements Serializable{
      
	  /**
	 * 
	 */
	private static final long serialVersionUID = 7063476435576036680L;

	  private Long   id;
	  private String chaveDeAcesso;
	  private String codigoUF;
	  private String naturezaOperacao;
	  private String modeloDoc;
	  private String serie;
	  private String numDoc;
	  private String cnpjEmitente;
	  private String nomeEmitente;
	  
	  
	  private String numItem;
	  private String codItem;
	  private String descricao;
	  private String ncm;
	  private String cfop;
	  private String undComercial;
	 
	  private Double qtdComercia;	  
	  private Double vlUndComercial;
	  
	  private Double vlProduto;
	  private String codEanTrib;
	  
	  private String undTrib;
	  private Double qtdTrib;
	  private Double vlUnTrib;
	  private String indTot;
	  
	  
   public NotasFiscais() {
	
   }

    
	public NotasFiscais(String chaveDeAcesso, String numDoc, String codItem, String descricao) {
	super();
	this.chaveDeAcesso = chaveDeAcesso;
	this.numDoc = numDoc;
	this.codItem = codItem;
	this.descricao = descricao;
}


	public NotasFiscais( String chaveDeAcesso, String codigoUF, String naturezaOperacao, String modeloDoc,
		String serie, String numDoc, String cnpjEmitente, String nomeEmitente, String numItem, String codItem,
		String descricao, String ncm, String cfop, String undComercial, Double qtdComercia, Double vlUndComercial,
		Double vlProduto, String codEanTrib, String undTrib, Double qtdTrib, Double vlUnTrib, String indTot) {
	super();

	this.chaveDeAcesso = chaveDeAcesso;
	this.codigoUF = codigoUF;
	this.naturezaOperacao = naturezaOperacao;
	this.modeloDoc = modeloDoc;
	this.serie = serie;
	this.numDoc = numDoc;
	this.cnpjEmitente = cnpjEmitente;
	this.nomeEmitente = nomeEmitente;
	this.numItem = numItem;
	this.codItem = codItem;
	this.descricao = descricao;
	this.ncm = ncm;
	this.cfop = cfop;
	this.undComercial = undComercial;
	this.qtdComercia = qtdComercia;
	this.vlUndComercial = vlUndComercial;
	this.vlProduto = vlProduto;
	this.codEanTrib = codEanTrib;
	this.undTrib = undTrib;
	this.qtdTrib = qtdTrib;
	this.vlUnTrib = vlUnTrib;
	this.indTot = indTot;
}


	 
	public Long getId() {
		return id;
	}


	public String getChaveDeAcesso() {
		return chaveDeAcesso;
	}


	public String getCodigoUF() {
		return codigoUF;
	}


	public String getNaturezaOperacao() {
		return naturezaOperacao;
	}


	public String getModeloDoc() {
		return modeloDoc;
	}


	public String getSerie() {
		return serie;
	}


	public String getNumDoc() {
		return numDoc;
	}


	public String getCnpjEmitente() {
		return cnpjEmitente;
	}


	public String getNomeEmitente() {
		return nomeEmitente;
	}


	public String getNumItem() {
		return numItem;
	}


	public String getCodItem() {
		return codItem;
	}


	public String getDescricao() {
		return descricao;
	}


	public String getNcm() {
		return ncm;
	}


	public String getCfop() {
		return cfop;
	}


	public String getUndComercial() {
		return undComercial;
	}


	public Double getQtdComercia() {
		return qtdComercia;
	}


	public Double getVlUndComercial() {
		return vlUndComercial;
	}


	public Double getVlProduto() {
		return vlProduto;
	}


	public String getCodEanTrib() {
		return codEanTrib;
	}


	public String getUndTrib() {
		return undTrib;
	}


	public Double getQtdTrib() {
		return qtdTrib;
	}


	public Double getVlUnTrib() {
		return vlUnTrib;
	}


	public String getIndTot() {
		return indTot;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotasFiscais other = (NotasFiscais) obj;
		return Objects.equals(id, other.id);
	}
	  
	  
	
}



