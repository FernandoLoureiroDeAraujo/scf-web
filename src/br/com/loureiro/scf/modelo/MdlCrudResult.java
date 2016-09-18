package br.com.loureiro.scf.modelo;

import java.sql.ResultSet;

public abstract class MdlCrudResult {

	public abstract void onSucess(ResultSet rset) throws Exception;
	
}
