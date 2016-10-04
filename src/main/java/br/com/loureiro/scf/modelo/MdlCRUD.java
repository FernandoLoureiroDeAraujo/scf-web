package br.com.loureiro.scf.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.loureiro.scf.util.UtlScf;
import br.com.loureiro.scf.vo.VoSaldo;

public class MdlCRUD extends MdlConexaoBanco {
	
	private static final Logger logger = LogManager.getLogger(MdlCRUD.class);
	
	Connection conn = null;
	PreparedStatement stmt = null;	
	ResultSet rset = null;
	
	Map<Integer, Object[]> fields = null;

	public void save(Object mClass) throws Exception {		
		try {			
			fields = UtlScf.getFieldNamesAndValues(mClass);

			conn = getConexao();
			stmt = conn.prepareStatement(mountSaveQuery(mClass));			

			for(int i = 1, index = 1; i < fields.size(); i++) {
				Object[] objects = fields.get(i);
				if(i == 4) {
					stmt.setDate(index++, Date.valueOf((LocalDate) objects[1]));
				} else {
					stmt.setObject(index++, objects[1]);
				}
			}
			
			logger.debug(stmt.toString());
			
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
		
		for (int i = 0; i < fields.size() - 1; i++) {
			if(!(i == fields.size() - 2)) { 
				str.append("?,");
			} else {
				str.append("?)");
			}
		}

		return str.toString();
	}
	
	public void find(Class<?> mClass, VoSaldo vo, MdlCrudResult crudResult) throws Exception {
        try {
        	conn = getConexao();
            stmt = conn.prepareStatement(mountFindQuery(mClass, vo));
            stmt.setDate(1, Date.valueOf(vo.getData1()));
            stmt.setDate(2, Date.valueOf(vo.getData2()));
            
    		logger.debug(stmt.toString());
            
            rset = stmt.executeQuery();

        	crudResult.onSucess(rset);
        } finally {
            fecharTodasConexoes(conn, stmt, rset);
        }
	}
	
	private String mountFindQuery(Class<?> mClass, VoSaldo vo) {
		StringBuilder str = new StringBuilder();
		str.append(" SELECT * FROM ");		
		str.append(mClass.getSimpleName().replace("Vo", "Tbl"));
		str.append(" WHERE PERIODO ");
		str.append(" BETWEEN (?) AND (?) ");
		return str.toString();
	}
	
}