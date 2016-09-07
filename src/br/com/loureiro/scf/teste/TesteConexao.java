package br.com.loureiro.scf.teste;

import org.junit.Test;

import br.com.loureiro.scf.modelo.MdlConexaoBanco;

public class TesteConexao {

	@Test
	public void testarConexao() {
		MdlConexaoBanco conn = new MdlConexaoBanco();
		conn.getConexao();
	}
	
}
