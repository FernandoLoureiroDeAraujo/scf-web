package br.com.loureiro.scf.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import br.com.loureiro.scf.util.UtlScf;

public class MdlCRUD extends MdlConexaoBanco {
	
	Map<Integer, Object[]> fields = null;
	
	public void save(Object mClass) throws Exception {
		
		Connection conn = null;
		PreparedStatement stmt = null;	
		
		try {
			
			fields = UtlScf.getFieldNamesAndValues(mClass);

			conn = getConexao();
			stmt = conn.prepareStatement(mountSaveQuery(mClass));			

			for(int i = 0, index = 1; i < fields.size(); i++) {
				Object[] objects = fields.get(i);
				stmt.setObject(index++, objects[1]);
			}
			
			stmt.executeUpdate();
			
		} finally {
			fecharTodasConexoes(conn, stmt);
		}
	}
	
	private String mountSaveQuery(Object mClass) {
		
		StringBuilder str = new StringBuilder();
		str.append(" INSERT INTO ");
		str.append(mClass.getClass().getSimpleName().replace("Vo", "Tbl"));
		str.append(" VALUES (");
		
		for (int i = 0; i < fields.size(); i++) {
			if(!(i == fields.size() - 1)) 
				str.append("?,");
			else 
				str.append("?)");
		}
		
		return str.toString();
	}
}