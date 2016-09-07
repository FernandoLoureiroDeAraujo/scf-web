package br.com.loureiro.scf.vo;

import java.io.Serializable;

public class VoSaldo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double saldo;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}