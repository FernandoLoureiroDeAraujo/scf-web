package br.com.loureiro.scf.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.loureiro.scf.constante.EnumTipoConta;
import br.com.loureiro.scf.util.UtlScf;
import br.com.loureiro.scf.vo.VoSaldo;

public class MdlCRUD extends MdlConexaoBanco {
	
	private static final Logger logger = LogManager.getLogger(MdlCRUD.class);
	
	Connection conn = null;
	PreparedStatement stmt = null;	
	ResultSet rset = null;
	
	public void save(Object mClass) throws Exception {		
		try {			
			Map<Integer, Object[]> fields = UtlScf.getFieldNamesAndValues(mClass);

			conn = getConexao();
			stmt = conn.prepareStatement(mountSaveQuery());			

			for(int i = 1, index = 1; i < fields.size(); i++) {
				Object[] objects = fields.get(i);
				if(i == 3) {
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
	
	private String mountSaveQuery() {
		StringBuilder str = new StringBuilder();
		str.append(" INSERT INTO TblControleFinanceiro ");		
		str.append(" VALUES (null,?,?,?,?) ");
		return str.toString();
	}
	
	public void find(VoSaldo vo, EnumTipoConta mEnum, MdlCrudResult crudResult) throws Exception {
        try {
        	conn = getConexao();
            stmt = conn.prepareStatement(mountFindQuery());
            stmt.setInt (1, mEnum.getValor());
            stmt.setDate(2, Date.valueOf(vo.getData1()));
            stmt.setDate(3, Date.valueOf(vo.getData2()));
            
    		logger.debug(stmt.toString());
            
            rset = stmt.executeQuery();

        	crudResult.onSucess(rset);
        } finally {
            fecharTodasConexoes(conn, stmt, rset);
        }
	}
	
	private String mountFindQuery() {
		StringBuilder str = new StringBuilder();
		str.append(" SELECT * FROM TblControleFinanceiro ");		
		str.append(" WHERE TIPO_PAGAMENTO = ? ");
		str.append(" AND PERIODO BETWEEN (?) AND (?) ");
		return str.toString();
	}
	
}