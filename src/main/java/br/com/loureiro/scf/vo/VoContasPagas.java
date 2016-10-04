package br.com.loureiro.scf.vo;

import java.time.LocalDate;

import br.com.loureiro.scf.constante.EnumTipoConta;

public class VoContasPagas extends VoContas {
	
	public VoContasPagas() {}
	
	public VoContasPagas(Integer id, String descricao, Double valor, LocalDate data, Integer tipoPagamento) {
		super(id, descricao, valor, data, tipoPagamento);		
	}
	
	public VoContasPagas(EnumTipoConta enumTipoConta, Integer id, String descricao, Double valor, LocalDate data, Integer tipoPagamento) {
		super(enumTipoConta, id, descricao, valor, data, tipoPagamento);		
	}
	
}