package br.com.loureiro.scf.constante;

public enum EnumTipoConta {

	TOTAL(-1, "Total"),
	CONTA_PAGA(0, "Conta paga"), 
	CONTA_RECEBIDA(1, "Conta recebida");
	
	private final Integer valor;
    private final String descricao;
    
    private EnumTipoConta(Integer valor, String descricao) {
    	this.valor = valor;
		this.descricao = descricao;
	}
    
    public Integer getValor() {
		return valor;
	}
    public String getDescricao() {
		return descricao;
	}
    
    public static EnumTipoConta getEnumTipoConta(Integer id) {
        if(id == null) return null;
        for (EnumTipoConta enumTipoConta : EnumTipoConta.values()) {
            if(enumTipoConta.getValor().equals(id)) return enumTipoConta;
        }
        return null;
    }
}