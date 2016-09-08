package br.com.loureiro.scf.vo;

import java.util.Date;

public class VoContasPagar extends VoContas {
	
	private Date dataVencimento;
	private Integer tipoPagamento;
	
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public Integer getTipoPagamento() {
		return tipoPagamento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public void setTipoPagamento(Integer tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
}