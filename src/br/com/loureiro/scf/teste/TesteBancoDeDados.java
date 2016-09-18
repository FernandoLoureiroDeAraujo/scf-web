package br.com.loureiro.scf.teste;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loureiro.scf.modelo.MdlCRUD;
import br.com.loureiro.scf.modelo.MdlConexaoBanco;
import br.com.loureiro.scf.modelo.MdlCrudResult;
import br.com.loureiro.scf.vo.VoContasReceber;

public class TesteBancoDeDados {

	@Test
	@Ignore
	public void testeConexao() {
		MdlConexaoBanco conn = new MdlConexaoBanco();
		conn.getConexao();
	}
	
	@Test
	@Ignore
	public void testeSalvarContasReceber() throws Exception {		
		MdlCRUD crud = new MdlCRUD();		
		crud.save(new VoContasReceber(null, "Conta", 100D, new Date(), 1));
	}
	
	@Test
	@Ignore
	public void testeSelecionarContasReceber() throws Exception {
		
		MdlCRUD crud = new MdlCRUD();
		
		List<VoContasReceber> lista = new ArrayList<>();

		crud.findAll(VoContasReceber.class, new MdlCrudResult() {
			@Override
			public void onSucess(final ResultSet rset) throws Exception {
				while(rset.next()) {
					lista.add(new VoContasReceber(	rset.getInt(1), 
													rset.getString(2), 
													rset.getDouble(3), 
													rset.getDate(4), 
													rset.getInt(5)));
				}
			}
		});
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}		
	}
}