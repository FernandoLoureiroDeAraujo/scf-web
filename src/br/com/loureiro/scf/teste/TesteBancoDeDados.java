package br.com.loureiro.scf.teste;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loureiro.scf.modelo.MdlCRUD;
import br.com.loureiro.scf.modelo.MdlConexaoBanco;
import br.com.loureiro.scf.vo.VoContasReceber;

public class TesteBancoDeDados {

	@Test
	@Ignore
	public void testarConexao() {
		MdlConexaoBanco conn = new MdlConexaoBanco();
		conn.getConexao();
	}
	
	@Test
	@Ignore
	public void testarSalvarContasReceber() throws Exception {
		
		MdlCRUD crud = new MdlCRUD();

		VoContasReceber vo = new VoContasReceber();
//		vo.setId(null);
		vo.setDescricao("Conta de luz");
		vo.setValor(100D);
		
		crud.save(vo);
	}
}
