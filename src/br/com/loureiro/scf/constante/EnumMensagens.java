package br.com.loureiro.scf.constante;

public enum EnumMensagens {
	
	// STATUS 200 - SUCESSO
	DADOS_INSERIDOS_COM_SUCESSO("Dados inseridos com sucesso"),
	
	//STATUS 500 - ERRO SERVIDOR
	ERRO_SERVICO_TEMPORARIAMENTE_INDISPONIVEL("Serviço temporariamente indisponível");
	
    private final String mensagem;
    
    private EnumMensagens(String mensagem) {
		this.mensagem = mensagem;
	}
    public String get() {
		return mensagem;
	}	
}