package br.com.loureiro.scf.constante;

public enum EnumTipoConta {

	CONTA_PAGAR("Contas pagas"), 
	CONTA_RECEBER("Contas recebidas");
	
    private final String tipoConta;
    
    private EnumTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
    public String get() {
		return tipoConta;
	}
}