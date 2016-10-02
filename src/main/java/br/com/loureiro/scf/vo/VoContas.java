package br.com.loureiro.scf.vo;

import java.time.LocalDate;

import br.com.loureiro.scf.constante.EnumTipoConta;
import br.com.loureiro.scf.util.UtlScf;

public class VoContas {
	
	protected EnumTipoConta enumTipoConta;
	protected Integer id;
	protected String descricao;
	protected Double valor;
	protected LocalDate data;
	protected Integer tipoPagamento;

	public VoContas() {}
	
	public VoContas(Integer id, String descricao, Double valor, LocalDate data, Integer tipoPagamento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.tipoPagamento = tipoPagamento;
	}
	
	public VoContas(EnumTipoConta enumTipoConta, Integer id, String descricao, Double valor, LocalDate data, Integer tipoPagamento) {
		super();
		this.enumTipoConta = enumTipoConta;
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.tipoPagamento = tipoPagamento;
	}
	
	public EnumTipoConta getEnumTipoConta() {
		return enumTipoConta;
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

	public LocalDate getData() {
		return data;
	}

	public Integer getTipoPagamento() {
		return tipoPagamento;
	}

	public void setEnumTipoConta(EnumTipoConta enumTipoConta) {
		this.enumTipoConta = enumTipoConta;
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

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setTipoPagamento(Integer tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	@Override
	public String toString() {
		return UtlScf.concatenar(	"VO[ ID=",id,
									", DESCRIÇÃO=", descricao,
									", VALOR=" + valor,
									", DATA=", data,
									", TIPO DE PAGAMENTO=", tipoPagamento, " ]");
	}
	
}