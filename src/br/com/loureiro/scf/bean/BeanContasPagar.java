package br.com.loureiro.scf.bean;

import javax.faces.bean.ManagedBean;

import br.com.loureiro.scf.constante.EnumMensagens;
import br.com.loureiro.scf.modelo.MdlCRUD;
import br.com.loureiro.scf.vo.VoContasPagar;

@ManagedBean
public class BeanContasPagar {
	
	VoContasPagar vo = new VoContasPagar();
	String status = null;
	
	public void salvarContaPagar() {
		
		MdlCRUD crud = null;
		
		try {
			crud = new MdlCRUD();
			crud.save(vo);
			
			status = EnumMensagens.DADOS_INSERIDOS_COM_SUCESSO.get();			
		} catch (Exception e) {
//			e.printStackTrace();
			status = EnumMensagens.ERRO_SERVICO_TEMPORARIAMENTE_INDISPONIVEL.get();
		}
	}

	public VoContasPagar getVo() {
		return vo;
	}

	public void setVo(VoContasPagar vo) {
		this.vo = vo;
	}
	
	public String getStatus() {
		return status;
	}
	
}