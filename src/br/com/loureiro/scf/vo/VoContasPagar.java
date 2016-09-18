package br.com.loureiro.scf.vo;

import java.util.Date;

public class VoContasPagar extends VoContas {
	
	public VoContasPagar() {}
	
	public VoContasPagar(Integer id, String descricao, Double valor, Date dataVencimento, Integer tipoPagamento) {
		super(id, descricao, valor, dataVencimento, tipoPagamento);
	}
	
}