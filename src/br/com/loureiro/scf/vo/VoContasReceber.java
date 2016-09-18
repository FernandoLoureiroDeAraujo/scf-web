package br.com.loureiro.scf.vo;

import java.util.Date;

public class VoContasReceber extends VoContas {
	
	public VoContasReceber() {}
	
	public VoContasReceber(Integer id, String descricao, Double valor, Date dataVencimento, Integer tipoPagamento) {
		super(id, descricao, valor, dataVencimento, tipoPagamento);
	}
	
}