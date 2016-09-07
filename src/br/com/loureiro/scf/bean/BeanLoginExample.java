package br.com.loureiro.scf.bean;

import javax.faces.bean.ManagedBean;

import br.com.loureiro.scf.vo.VoLogin;

@ManagedBean(name = "beanLogin")
public class BeanLoginExample {

	private VoLogin login = new VoLogin();
	
	public String UservalidOrnot() {
		
//		login = new VoLogin();
		
		if (login.getUname().equals("admin") && login.getPassword().equals("admin")) {
			return "sucesso"; // PROCURA PELA PAGINA SUCESSO.XHTML
		} else {
			return "error"; // PROCURA PELA PAGINA ERRO.XHTML
		}
	}

	public VoLogin getLogin() {
		return login;
	}

	public void setLogin(VoLogin login) {
		this.login = login;
	}
}
