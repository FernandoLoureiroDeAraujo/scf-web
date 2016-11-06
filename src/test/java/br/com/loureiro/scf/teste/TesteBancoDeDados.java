package br.com.loureiro.scf.teste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loureiro.scf.constante.EnumTipoConta;
import br.com.loureiro.scf.modelo.MdlCRUD;
import br.com.loureiro.scf.modelo.MdlConexaoBanco;
import br.com.loureiro.scf.vo.VoContas;
import br.com.loureiro.scf.vo.VoSaldo;

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
		crud.save(new VoContas(null, "Conta 2", 100D, LocalDate.now(), EnumTipoConta.CONTA_PAGA));
	}
	
	Double somarReceber = 0D;
	
	@Test
	@Ignore
	public void testeSelecionarContasPagas() throws Exception {
		
		VoSaldo vo = new VoSaldo(LocalDate.of(2000, 1, 1), LocalDate.of(2070, 1, 1));
		List<VoContas> lista = new ArrayList<>();
		
		new MdlCRUD().find(vo, EnumTipoConta.CONTA_PAGA, (rset) -> { 
			while(rset.next()) {
				lista.add(new VoContas(rset.getInt(1), 
											rset.getString(2), 
											rset.getDouble(3), 
											LocalDate.parse(rset.getDate(4).toString()),
											EnumTipoConta.getEnumTipoConta(rset.getInt(5))));
				
				somarReceber += rset.getDouble(3);
			}
		});
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		
		System.out.println("\nTOTAL = " + somarReceber);
	}
}