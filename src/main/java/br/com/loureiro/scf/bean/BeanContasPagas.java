package br.com.loureiro.scf.bean;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.loureiro.scf.modelo.MdlCRUD;
import br.com.loureiro.scf.vo.VoContasPagas;

@ManagedBean
public class BeanContasPagas {
	
	private static final Logger logger = LogManager.getLogger(BeanContasPagas.class);
	
	VoContasPagas vo = new VoContasPagas();
	int status = -1;
	public void salvarContaPagas() {
		
		MdlCRUD crud = null;
		
		try {
			logger.debug("\niniciando salvar contas pagas");
			logger.debug(vo.toString());
			
			crud = new MdlCRUD();
			crud.save(vo);
			
			status = 1;
			logger.debug(status);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			status = 0;
		}

	}

	public VoContasPagas getVo() {
		return vo;
	}

	public void setVo(VoContasPagas vo) {
		this.vo = vo;
	}
	
	public int getStatus() {
		return status;
	}
	
}