package com.leetor4.model.nfe;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {

	private Identificacao ident = new Identificacao();
	
	private Emitente emitente = new Emitente();
	
	private Destinatario destinatario = new Destinatario();
	
	private List<Produtos> prods = new ArrayList<Produtos>();
	
	private Total total = new Total();

	public Identificacao getIdent() {
		return ident;
	}

	public void setIdent(Identificacao ident) {
		this.ident = ident;
	}

	public Emitente getEmitente() {
		return emitente;
	}

	public void setEmitente(Emitente emitente) {
		this.emitente = emitente;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public List<Produtos> getProds() {
		return prods;
	}

	public void setProds(List<Produtos> prods) {
		this.prods = prods;
	}
 
	public void adicionarProdutos(Produtos prod) {
		prods.add(prod);
	}
	

	public Total getTotal() {
		return total;
	}

	public void setTotal(Total total) {
		this.total = total;
	}
	
	
}
