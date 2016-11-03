package br.com.loureiro.scf.constante;

public enum EnumStatus {

	INDEFINIDO(-1), 
	SUCESSO(1), 
	ERROR(0);
	
    private final int status;
    
    private EnumStatus(int status) {
		this.status = status;
	}
    public int get() {
		return status;
	}
	
}