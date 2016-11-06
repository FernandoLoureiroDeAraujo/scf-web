package br.com.loureiro.scf.bean;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.loureiro.scf.constante.EnumStatus;
import br.com.loureiro.scf.constante.EnumTipoConta;
import br.com.loureiro.scf.modelo.MdlCRUD;
import br.com.loureiro.scf.vo.VoContas;

@ManagedBean
public class BeanContasPagas {
	
	private static final Logger logger = LogManager.getLogger(BeanContasPagas.class);
	
	private int status = EnumStatus.INDEFINIDO.get();
	VoContas vo = new VoContas();
	
	public void salvarContaPagas() {
		vo.setTipoPagamento(EnumTipoConta.CONTA_PAGA);
		MdlCRUD crud = null;
		
		try {
			logger.debug("iniciando salvar contas pagas");
			logger.debug(vo.toString());
			
			crud = new MdlCRUD();
			crud.save(vo);
		
			status = EnumStatus.SUCESSO.get();
			vo = new VoContas(); // LIMPA FORMULARIO
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			status = EnumStatus.ERROR.get();
		}

		
	}

	public VoContas getVo() {
		return vo;
	}

	public void setVo(VoContas vo) {
		this.vo = vo;
	}
	
	public int getStatus() {
		return status;
	}
	
}