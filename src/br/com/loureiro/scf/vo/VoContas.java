package br.com.loureiro.scf.vo;

import java.io.Serializable;

public class VoContas implements Serializable {

	private static final long serialVersionUID = 1L;

	private String conta;
	private Double valor;
	
	public String getConta() {
		return conta;
	}
	public Double getValor() {
		return valor;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}