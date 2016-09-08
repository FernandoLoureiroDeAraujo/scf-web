package br.com.loureiro.scf.vo;

public class VoContas {
	
	private Integer id;
	private String descricao;
	private Double valor;
	
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
}