package br.com.loureiro.scf.bean;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.loureiro.scf.constante.EnumStatus;
import br.com.loureiro.scf.modelo.MdlCRUD;
import br.com.loureiro.scf.vo.VoContasPagas;

@ManagedBean
public class BeanContasPagas {
	
	private static final Logger logger = LogManager.getLogger(BeanContasPagas.class);
	
	private int status = EnumStatus.INDEFINIDO.get();
	VoContasPagas vo = new VoContasPagas();
	
	public void salvarContaPagas() {
		vo.setTipoPagamento(1);
		MdlCRUD crud = null;
		
		try {
			logger.debug("\niniciando salvar contas pagas");
			logger.debug(vo.toString());
			
			crud = new MdlCRUD();
			crud.save(vo);
			
			status = EnumStatus.SUCESSO.get();
			logger.debug(status);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			status = EnumStatus.ERROR.get();
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