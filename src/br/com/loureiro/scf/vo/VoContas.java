package br.com.loureiro.scf.vo;

import java.util.Date;

import br.com.loureiro.scf.util.UtlScf;

public class VoContas {
	
	protected Integer id;
	protected String descricao;
	protected Double valor;
	protected Date dataVencimento;
	protected Integer tipoPagamento;

	public VoContas() {}
	
	public VoContas(Integer id, String descricao, Double valor, Date dataVencimento, Integer tipoPagamento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.tipoPagamento = tipoPagamento;
	}
	
	public Integer getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
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

	@Override
	public String toString() {
		return UtlScf.concatenar(	"VO[ ID=",id,
									", DESCRIÇÃO=", descricao,
									", VALOR=" + valor,
									", DATA DE VENCIMENTO=", dataVencimento,
									", TIPO DE PAGAMENTO=", tipoPagamento, " ]");
	}
	
}