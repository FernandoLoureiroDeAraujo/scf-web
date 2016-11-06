package br.com.loureiro.scf.vo;

import java.time.LocalDate;

import br.com.loureiro.scf.constante.EnumTipoConta;
import br.com.loureiro.scf.util.UtlScf;

public class VoContas {
	
	private Integer id;
	private String descricao;
	private Double valor;
	private LocalDate data;
	private Integer tipoPagamento;

	public VoContas() {}
	
	public VoContas(Integer id, String descricao, Double valor, LocalDate data, EnumTipoConta tipoPagamento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.tipoPagamento = tipoPagamento.getValor();
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

	public String getDataAsString() {
		return UtlScf.formatarData(data);
	}
	
	public LocalDate getData() {
		return data;
	}

	public EnumTipoConta getTipoPagamento() {
		return EnumTipoConta.getEnumTipoConta(tipoPagamento);
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

	public void setTipoPagamento(EnumTipoConta tipoPagamento) {
		this.tipoPagamento = tipoPagamento.getValor();
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