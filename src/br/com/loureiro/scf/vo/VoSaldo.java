package br.com.loureiro.scf.vo;

import java.util.Date;

public class VoSaldo extends VoContas {
	
	public VoSaldo(String descricao, Double valor, Date dataVencimento, Integer tipoPagamento) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.tipoPagamento = tipoPagamento;
	}
	
}