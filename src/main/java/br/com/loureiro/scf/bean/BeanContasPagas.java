package br.com.loureiro.scf.bean;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.loureiro.scf.constante.EnumMensagens;
import br.com.loureiro.scf.modelo.MdlCRUD;
import br.com.loureiro.scf.vo.VoContasPagas;

@ManagedBean
public class BeanContasPagas {
	
	private static final Logger logger = LogManager.getLogger(BeanContasPagas.class);
	
	VoContasPagas vo = new VoContasPagas();
	String status = null;
	
	public void salvarContaPagas() {
		
		MdlCRUD crud = null;
		
		try {
			logger.debug("\niniciando salvar contas pagas");
			logger.debug(vo.toString());
			
			crud = new MdlCRUD();
			crud.save(vo);
			
			status = EnumMensagens.DADOS_INSERIDOS_COM_SUCESSO.get();		
			
			logger.debug(status);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			status = EnumMensagens.ERRO_SERVICO_TEMPORARIAMENTE_INDISPONIVEL.get();
		}
	}

	public VoContasPagas getVo() {
		return vo;
	}

	public void setVo(VoContasPagas vo) {
		this.vo = vo;
	}
	
	public String getStatus() {
		return status;
	}
	
}