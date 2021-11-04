package com.leetor4.model.nfe;



public class Emitente {

	private String cnpj;
	private String nome;
	private String nomeFantasia;
	private String ie;
	private String crt;
	
	private Endereco end = new Endereco();

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getCrt() {
		return crt;
	}

	public void setCrt(String crt) {
		this.crt = crt;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}
	
	
}
