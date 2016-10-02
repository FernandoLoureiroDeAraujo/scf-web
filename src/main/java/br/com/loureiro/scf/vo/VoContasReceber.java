package br.com.loureiro.scf.vo;

import java.time.LocalDate;

import br.com.loureiro.scf.constante.EnumTipoConta;

public class VoContasReceber extends VoContas {
	
	public VoContasReceber() {}

	public VoContasReceber(Integer id, String descricao, Double valor, LocalDate dataRecebimento, Integer tipoPagamento) {
		super(id, descricao, valor, dataRecebimento, tipoPagamento);
	}
	
	public VoContasReceber(EnumTipoConta enumTipoConta, Integer id, String descricao, Double valor, LocalDate dataRecebimento, Integer tipoPagamento) {
		super(enumTipoConta, id, descricao, valor, dataRecebimento, tipoPagamento);
	}
	
}