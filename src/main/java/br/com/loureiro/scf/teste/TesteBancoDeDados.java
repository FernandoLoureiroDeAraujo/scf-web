package br.com.loureiro.scf.teste;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import org.junit.Ignore;
import org.junit.Test;

import br.com.loureiro.scf.constante.EnumTipoConta;
import br.com.loureiro.scf.modelo.MdlCRUD;
import br.com.loureiro.scf.modelo.MdlConexaoBanco;
import br.com.loureiro.scf.vo.VoContasPagas;
import br.com.loureiro.scf.vo.VoContasReceber;
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
		crud.save(new VoContasReceber(null, "Conta 2", 100D, LocalDate.now(), 1));
	}
	
	Double somarReceber = 0D;
	
	@Test
	public void testeSelecionarContasPagas() throws Exception {
		
		VoSaldo vo = new VoSaldo(LocalDate.of(2000, 1, 1), LocalDate.of(2070, 1, 1));
		List<VoContasPagas> lista = new ArrayList<>();
		
		new MdlCRUD().find(VoContasPagas.class, vo, (rset) -> { 
			while(rset.next()) {
				lista.add(new VoContasPagas(EnumTipoConta.CONTA_PAGAR,
											rset.getInt(1), 
											rset.getString(2), 
											rset.getDouble(3), 
											LocalDate.parse(rset.getDate(4).toString()),
											rset.getInt(5)));
				
				somarReceber += rset.getDouble(3);
			}
		});
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		
		System.out.println("\nTOTAL = " + somarReceber);
	}
}