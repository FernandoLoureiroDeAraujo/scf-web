package br.com.loureiro.scf.bean;

import javax.faces.bean.ManagedBean;

import br.com.loureiro.scf.constante.EnumMensagens;
import br.com.loureiro.scf.vo.VoLoginExample;

@ManagedBean(name = "beanLogin")
public class BeanLoginExample {

	private VoLoginExample login = new VoLoginExample();
	private String status;
	
	/**
	 * RETORNAR PARA MESMA PAGINA 1
	 * @return boolean
	 */
//	public void UservalidOrnot() {
//		if (login.getUname().equals("admin") && login.getPassword().equals("admin")) {
//			STATUS = true;
//		} else {
//			STATUS = false;
//		}
//	}
	
	/**
	 * RETORNAR PARA MESMA PAGINA 2
	 */
	public void UservalidOrnot() {
		if (login.getUname().equals("admin") && login.getPassword().equals("admin")) {
			status = EnumMensagens.DADOS_INSERIDOS_COM_SUCESSO.get();			
		} else {
			status = EnumMensagens.ERRO_SERVICO_TEMPORARIAMENTE_INDISPONIVEL.get();
		}
	}
	
	/**
	 * VAI PARA OUTRA PAGINA
	 * @return String
	 */
//	public String UservalidOrnot() {
//		
////		login = new VoLogin();
//		
//		if (login.getUname().equals("admin") && login.getPassword().equals("admin")) {
//			return "sucesso"; // PROCURA PELA PAGINA SUCESSO.XHTML
//		} else {
//			return "error"; // PROCURA PELA PAGINA ERRO.XHTML
//		}
//	}

	public VoLoginExample getLogin() {
		return login;
	}

	public void setLogin(VoLoginExample login) {
		this.login = login;
	}
	
	public String getStatus() {
		return status;
	}
	
}
